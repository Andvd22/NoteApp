// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

    // SỬA: Xóa phiên bản cứng và thay bằng alias (ksp="2.0.21-1.0.25" từ toml)
    alias(libs.plugins.ksp) apply false

    // SỬA: Thêm Navigation Safe Args bằng alias
    alias(libs.plugins.navigation.safeargs) apply false
}

// XÓA: Block buildscript cũ không còn cần thiết vì đã chuyển sang plugins block
// buildscript { ... }