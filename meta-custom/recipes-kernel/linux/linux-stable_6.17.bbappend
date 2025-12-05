# 扩展 linux-stable 以支持 am3359 机器
# COMPATIBLE_MACHINE 是正则表达式，需要匹配 beaglebone 或 am3359
COMPATIBLE_MACHINE = "^(beaglebone|am3359)$"

# 添加 am3359 的 defconfig 文件搜索路径
FILESEXTRAPATHS:prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

