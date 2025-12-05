# recipes-example 目录

此目录用于存放你的自定义 recipes 和 bbappend 文件。

## 如何使用 bbappend 文件覆盖 meta-bbb 的配置

如果你想要修改 meta-bbb 层中的某个 recipe，可以在这里创建对应的 `.bbappend` 文件。

### 示例：覆盖 meta-bbb 中的 recipe

假设 meta-bbb 中有一个 recipe：`recipes-kernel/linux/linux-stable_6.17.bb`

你可以创建：
```
recipes-kernel/linux/linux-stable_6.17.bbappend
```

然后在 bbappend 文件中添加你的自定义配置：
```bitbake
# 添加自定义补丁
SRC_URI += "file://your-patch.patch"

# 修改配置
EXTRA_OEMAKE += "YOUR_OPTION=value"
```

### 目录结构建议

- `recipes-kernel/` - 内核相关的 recipes 和 bbappend
- `recipes-bsp/` - BSP 相关的 recipes 和 bbappend
- `recipes-qt/` - Qt 相关的 recipes 和 bbappend
- `recipes-support/` - 支持工具相关的 recipes 和 bbappend
- `images/` - 自定义镜像定义

