# Multi-type RecyclerView: one RecyclerView, many row types

Date: 24 November 2025

## TL;DR
A clean, maintainable pattern to display heterogeneous rows (headers, match rows, team rows, group items, etc.) in a single RecyclerView. The MultyViewTypeRecyclerView repo demonstrates a small, extensible model (`ListItem`), layered adapters to map view types to ViewHolders, and ViewModel-level mapping to compose the final list.

---

## Why a single RecyclerView?
- Single scrolling container, unified animations and layout behavior.
- Easier to maintain and extend: add a row type by introducing a new `ListItem` subtype and a ViewHolder.
- Keeps mapping logic (domain -> UI rows) out of adapters; the adapter simply renders what it's given.

## Project at a glance
Open the project and inspect these key files:
- `app/src/main/java/com/xtensolutions/multyviewtyperecyclerview/model/ListItem.kt` — the sealed `ListItem` model (Section, Match, Team, Group).
- `app/src/main/java/com/xtensolutions/multyviewtyperecyclerview/model/ListSection.kt` — small header data class.
- `app/src/main/java/com/xtensolutions/multyviewtyperecyclerview/core/adapter/ListItemHeaderSectionAdapter.kt` — base adapter with header detection.
- `app/src/main/java/com/xtensolutions/multyviewtyperecyclerview/ui/adapter/ListSectionAdapter.kt` — header ViewHolder creation & binding.
- `app/src/main/java/com/xtensolutions/multyviewtyperecyclerview/ui/adapter/MatchAdapter.kt`, `TeamAdapter.kt`, `GroupAdapter.kt` — adapters specialized for match/team/group rows.
- `app/src/main/java/com/xtensolutions/multyviewtyperecyclerview/ui/viewmodel/MatchResultViewModel.kt` — example mapping from repositories to `LinkedList<ListItem<*>>`.

## Core idea: the `ListItem` model
This repo uses a sealed class called `ListItem` which represents every row type. The pattern is simple and expressive:

- `Section` — header row (implements `ListItemHeaderSection`).
- `Match` — match result row.
- `Team` — team points row.
- `Group` — group descriptor/row.

Why sealed classes?
- Centralizes row types.
- Makes view-type decisions simple and explicit.
- Encourages exhaustive `when` handling when using `when` expressions.

## How adapters decide view types (pattern)
Each adapter inspects the list item and returns its view type integer.

Pattern (simplified):

- `getItemViewType(position)` → inspect `getItem(position)` and return a constant (e.g., `MATCH_TYPE`, `TEAM_TYPE`, `GROUP_TYPE`, `HEADER`).
- `onCreateViewHolder(parent, viewType)` → inflate the corresponding layout and return ViewHolder.
- `onBindViewHolder(holder, position)` → cast holder and item and call `bind()`.

Example (pattern, simplified):

```kotlin
override fun getItemViewType(position: Int): Int {
    val item = getItem(position)
    return when (item) {
        is ListItem.Match<*> -> MATCH_TYPE
        is ListItem.Team<*>  -> TEAM_TYPE
        is ListItem.Group<*> -> GROUP_TYPE
        is ListItem.Section<*> -> HEADER
        else -> super.getItemViewType(position)
    }
}
```

```kotlin
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return when(viewType) {
        MATCH_TYPE -> {
            val binding = ListItemRowMatchBinding.inflate(inflater, parent, false)
            MatchViewHolder(binding)
        }
        TEAM_TYPE -> { /* ... */ }
        HEADER -> { /* header view holder */ }
        else -> super.onCreateViewHolder(parent, viewType)
    }
}

override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val item = getItem(position)
    when {
      holder is MatchViewHolder && item is ListItem.Match<*> -> holder.bind(item.data as MatchResult)
      holder is TeamViewHolder && item is ListItem.Team<*> -> holder.bind(item.data as GroupTeamPoints)
      holder is SectionViewHolder && item is ListItem.Section<*> -> holder.bind(item.component1() as String)
      else -> super.onBindViewHolder(holder, position)
    }
}
```

> Note: This project uses DataBinding generated bindings (e.g., `ListItemRowMatchBinding`, `ListItemRowTeamBinding`) and small ViewHolder wrappers to bind payloads.

## ViewModel: compose your UI list
Keep mapping logic in the ViewModel. In `MatchResultViewModel.kt` the repo maps repository data into a `LinkedList<ListItem<*>>`:

```kotlin
fun mappingMatchResultWithGroupTeam(
    matches: List<MatchResult>,
    teams: List<GroupTeamPoints>
): LinkedList<ListItem<*>> {
    return LinkedList<ListItem<*>>().apply {
        add(ListItem.Section<String>("Matches"))
        addAll(matches.map { ListItem.Match(it) })
        // group/teams...
        add(ListItem.Section("Groups"))
        add(ListItem.Group(Group(groupId = 1, groupName = "Group A")))
        addAll(groupTeams.map { ListItem.Team(it) })
    }
}
```

This keeps adapters simple: they render what they're handed.

## Step-by-step: add a new view type (complete)
Suppose you want to add an `AdBanner` row type.

1. Add a `ListItem` subtype
   - In `app/src/main/java/com/xtensolutions/multyviewtyperecyclerview/model/ListItem.kt` add:
     ```kotlin
     data class AdBanner<T>(override val data: T) : ListItem(data)
     ```
2. Create a layout
   - `res/layout/list_item_ad_banner.xml` — define DataBinding variables (e.g., `banner: AdBannerModel`).
3. Create a ViewHolder
   - `AdBannerViewHolder(private val binding: ListItemAdBannerBinding) : BaseViewHolder(binding.root) { fun bind(banner: AdBannerModel) { binding.banner = banner } }`
4. Add a view type constant
   - Add `const val AD_BANNER_TYPE = 5000` to the adapter you extend (or create a specialized adapter).
5. Update `getItemViewType`
   - Return `AD_BANNER_TYPE` when `getItem(position) is ListItem.AdBanner<*>`.
6. Inflate & bind
   - In `onCreateViewHolder`, when `viewType == AD_BANNER_TYPE`, inflate `ListItemAdBannerBinding` and return `AdBannerViewHolder`.
   - In `onBindViewHolder`, if holder is `AdBannerViewHolder` and item is `ListItem.AdBanner<*>`, call `holder.bind(item.data as AdBannerModel)`.
7. Map data in ViewModel
   - Add `ListItem.AdBanner(adModel)` to the `LinkedList<ListItem<*>>` you produce.

## Tips and best practices
- Keep domain → UI mapping in the ViewModel (not adapters).
- Use DataBinding or ViewBinding for minimal ViewHolder code.
- Prefer sealed classes for expressive, compile-time-safe models.
- Consider `ListAdapter` + `DiffUtil` for efficient updates.
- If the adapter grows too large, consider `ConcatAdapter` to compose separate adapters.
- Use stable IDs (`getItemId`) for proper animations during updates if possible.

## Performance notes
- Avoid heavy work in `onBindViewHolder`.
- Reuse view types and view holders — inflation is done in `onCreateViewHolder`.
- Use `DiffUtil` for granular list updates.
- Cache expensive image loads with an image loader (Glide/Picasso/Coil) and use placeholder states.

## Testing suggestions
- Unit test mapping functions in `MatchResultViewModel` to ensure ordering and grouping logic returns the expected `ListItem` sequence.
- Use instrumentation/UI tests (Espresso) to assert the presence of specific rows on the screen.

## Why this repo’s structure is effective
- The `ListItem` sealed class centralizes row definitions.
- Adapters are layered: `ListItemHeaderSectionAdapter` handles header logic, `ListSectionAdapter` implements header rendering, and specialized adapters like `MatchAdapter`, `TeamAdapter` and `GroupAdapter` add view types on top — a clean, composable layering.
- ViewModel mapping produces a single, presentation-ready list — adapters simply render.

## Getting started: build & run (quick)
- Open the project in Android Studio and run the app on a device/emulator.
- Or build with Gradle from the repo root:

```powershell
./gradlew assembleDebug
```

(Windows PowerShell: use `.uildin
elevant` or run `gradlew.bat assembleDebug` from project root.)

## Conclusion
A single RecyclerView with a small, consistent item model and clear adapter patterns makes multi-type lists maintainable and extensible. The MultyViewTypeRecyclerView project is a practical reference: its architecture shows how to map domain data to a list of typed items and how to keep adapters simple and modular.
