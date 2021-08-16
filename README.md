# 背景

## 非 SDK API 名单([谷歌官方](https://developer.android.com/guide/app-compatibility/restrictions-non-sdk-interfaces))

随着每个 Android 版本的发布，会有更多非 SDK 接口受到限制。 我们知道这些限制会影响您的发布工作流，同时我们希望确保您拥有相关工具来检测非 SDK 接口的使用情况、有机会[向我们提供反馈](https://developer.android.com/guide/app-compatibility/restrictions-non-sdk-interfaces#feature-request)，并且有时间根据相应新政策做出规划和调整。

为最大程度地降低非 SDK 使用限制对开发工作流的影响，我们将非 SDK 接口分成了几个名单，这些名单界定了非 SDK 接口使用限制的严格程度（取决于应用的目标 API 级别）。下表介绍了这些名单：

| 名单                          | 说明                                                         |
| :---------------------------- | :----------------------------------------------------------- |
| 屏蔽名单 (`blacklist`)        | 无论应用的[目标 API 级别](https://developer.android.com/distribute/best-practices/develop/target-sdk)是什么，您都无法使用的非 SDK 接口。 如果您的应用尝试访问其中任何一个接口，系统就会[抛出错误](https://developer.android.com/guide/app-compatibility/restrictions-non-sdk-interfaces#results-of-keeping-non-sdk)。 |
| 有条件屏蔽 (`greylist-max-x`) | 从 Android 9（API 级别 28）开始，当有应用以该 API 级别为目标平台时，我们会在每个 API 级别分别限制某些非 SDK 接口。这些名单会以应用无法再访问该名单中的非 SDK 接口之前可以作为目标平台的最高 API 级别 (`max-target-x`) 进行标记。例如，在 Android Pie 中未被屏蔽、但现在已被 Android 10 屏蔽的非 SDK 接口会列入 `max-target-p` (`greylist-max-p`) 名单，其中的“p”表示 Pie 或 Android 9（API 级别 28）。如果您的应用尝试访问受目标 API 级别限制的接口，系统就会[将此 API 视为已列入屏蔽名单](https://developer.android.com/guide/app-compatibility/restrictions-non-sdk-interfaces#results-of-keeping-non-sdk)。 |
| 不支持 (`greylist`)           | 当前不受限制且您的应用可以使用的非 SDK 接口。 但请注意，这些接口**不受支持**，可能会在未发出通知的情况下随时发生更改。预计这些接口在未来的 Android 版本中会被有条件地屏蔽，并列在 `max-target-x` 名单中。 |
| SDK (`whitelist`)             | 已在 Android 框架[软件包索引](https://developer.android.com/reference/packages)中正式记录、受支持并且可以自由使用的接口。 |

尽管您目前仍可以使用某些非 SDK 接口（取决于应用的目标 API 级别），但只要您使用任何非 SDK 方法或字段，终归存在导致应用出问题的显著风险。如果您的应用依赖于非 SDK 接口，建议您开始计划迁移到 SDK 接口或其他替代方案。如果您无法为应用中的功能找到无需使用非 SDK 接口的替代方案，我们建议您[请求添加新的公共 API](https://developer.android.com/guide/app-compatibility/restrictions-non-sdk-interfaces#feature-request)。

# 目的:

绕开非SDK接口限制，访问hiddenapi接口

## 目前已有的方案参考:

[Free reflection](https://github.com/tiann/FreeReflection)

# 兼容性：

android 9至android12-beta-4

# 与freereflection比较

|                            | RePublic | Free reflection |
| -------------------------- | -------- | --------------- |
| 使用setHiddenApiExemptions | 是       | 是              |
| 是否使用了bootclassloader  | 否       | 是              |
| 元反射                     | 否       | 是              |
| 兼容安卓11/12              | 是       | 不太清楚        |
| 第三方ROM兼容性得分        | 优秀     | 良好            |



# RePublic文章参考

[安卓hiddenapi访问绝技](https://bbs.pediy.com/thread-268936.htm)



# License

MIT License