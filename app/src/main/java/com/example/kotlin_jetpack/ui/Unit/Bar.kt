package com.example.kotlin_jetpack.ui.Unit

import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import org.xmlpull.v1.XmlPullParser

class Bar : GradientDrawable() {
    override fun draw(canvas: Canvas) {
        super.draw(canvas)
    }

    override fun getChangingConfigurations(): Int {
        return super.getChangingConfigurations()
    }

    override fun setDither(dither: Boolean) {
        super.setDither(dither)
    }

    override fun setAlpha(alpha: Int) {
        super.setAlpha(alpha)
    }

    override fun getAlpha(): Int {
        return super.getAlpha()
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        super.setColorFilter(colorFilter)
    }

    override fun setTintList(tint: ColorStateList?) {
        super.setTintList(tint)
    }

    override fun setTintBlendMode(blendMode: BlendMode?) {
        super.setTintBlendMode(blendMode)
    }

    override fun getColorFilter(): ColorFilter? {
        return super.getColorFilter()
    }

    override fun isStateful(): Boolean {
        return super.isStateful()
    }

    override fun hasFocusStateSpecified(): Boolean {
        return super.hasFocusStateSpecified()
    }

    override fun applyTheme(t: Resources.Theme) {
        super.applyTheme(t)
    }

    override fun canApplyTheme(): Boolean {
        return super.canApplyTheme()
    }

    override fun getOpacity(): Int {
        return super.getOpacity()
    }

    override fun onStateChange(stateSet: IntArray?): Boolean {
        return super.onStateChange(stateSet)
    }

    override fun onLevelChange(level: Int): Boolean {
        return super.onLevelChange(level)
    }

    override fun onBoundsChange(r: Rect?) {
        super.onBoundsChange(r)
    }

    override fun getIntrinsicWidth(): Int {
        return super.getIntrinsicWidth()
    }

    override fun getIntrinsicHeight(): Int {
        return super.getIntrinsicHeight()
    }

    override fun getPadding(padding: Rect): Boolean {
        return super.getPadding(padding)
    }

    override fun getOpticalInsets(): Insets {
        return super.getOpticalInsets()
    }

    override fun getOutline(outline: Outline) {
        super.getOutline(outline)
    }

    override fun mutate(): Drawable {
        return super.mutate()
    }

    override fun inflate(
        r: Resources,
        parser: XmlPullParser,
        attrs: AttributeSet,
        theme: Resources.Theme?
    ) {
        super.inflate(r, parser, attrs, theme)
    }

    override fun getConstantState(): ConstantState? {
        return super.getConstantState()
    }

    override fun setCornerRadii(radii: FloatArray?) {
        super.setCornerRadii(radii)
    }

    override fun getCornerRadii(): FloatArray? {
        return super.getCornerRadii()
    }

    override fun setCornerRadius(radius: Float) {
        super.setCornerRadius(radius)
    }

    override fun getCornerRadius(): Float {
        return super.getCornerRadius()
    }

    override fun setStroke(width: Int, color: Int) {
        super.setStroke(width, color)
    }

    override fun setStroke(width: Int, colorStateList: ColorStateList?) {
        super.setStroke(width, colorStateList)
    }

    override fun setStroke(width: Int, color: Int, dashWidth: Float, dashGap: Float) {
        super.setStroke(width, color, dashWidth, dashGap)
    }

    override fun setStroke(
        width: Int,
        colorStateList: ColorStateList?,
        dashWidth: Float,
        dashGap: Float
    ) {
        super.setStroke(width, colorStateList, dashWidth, dashGap)
    }

    override fun setSize(width: Int, height: Int) {
        super.setSize(width, height)
    }

    override fun setShape(shape: Int) {
        super.setShape(shape)
    }

    override fun getShape(): Int {
        return super.getShape()
    }

    override fun setGradientType(gradient: Int) {
        super.setGradientType(gradient)
    }

    override fun getGradientType(): Int {
        return super.getGradientType()
    }

    override fun setGradientCenter(x: Float, y: Float) {
        super.setGradientCenter(x, y)
    }

    override fun getGradientCenterX(): Float {
        return super.getGradientCenterX()
    }

    override fun getGradientCenterY(): Float {
        return super.getGradientCenterY()
    }

    override fun setGradientRadius(gradientRadius: Float) {
        super.setGradientRadius(gradientRadius)
    }

    override fun getGradientRadius(): Float {
        return super.getGradientRadius()
    }

    override fun setUseLevel(useLevel: Boolean) {
        super.setUseLevel(useLevel)
    }

    override fun getUseLevel(): Boolean {
        return super.getUseLevel()
    }

    override fun getOrientation(): Orientation {
        return super.getOrientation()
    }

    override fun setOrientation(orientation: Orientation?) {
        super.setOrientation(orientation)
    }

    override fun setColors(colors: IntArray?) {
        super.setColors(colors)
    }

    override fun setColors(colors: IntArray?, offsets: FloatArray?) {
        super.setColors(colors, offsets)
    }

    override fun getColors(): IntArray? {
        return super.getColors()
    }

    override fun setInnerRadiusRatio(innerRadiusRatio: Float) {
        super.setInnerRadiusRatio(innerRadiusRatio)
    }

    override fun getInnerRadiusRatio(): Float {
        return super.getInnerRadiusRatio()
    }

    override fun setInnerRadius(innerRadius: Int) {
        super.setInnerRadius(innerRadius)
    }

    override fun getInnerRadius(): Int {
        return super.getInnerRadius()
    }

    override fun setThicknessRatio(thicknessRatio: Float) {
        super.setThicknessRatio(thicknessRatio)
    }

    override fun getThicknessRatio(): Float {
        return super.getThicknessRatio()
    }

    override fun setThickness(thickness: Int) {
        super.setThickness(thickness)
    }

    override fun getThickness(): Int {
        return super.getThickness()
    }

    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        super.setPadding(left, top, right, bottom)
    }

    override fun setColor(argb: Int) {
        super.setColor(argb)
    }

    override fun setColor(colorStateList: ColorStateList?) {
        super.setColor(colorStateList)
    }

    override fun getColor(): ColorStateList? {
        return super.getColor()
    }
}