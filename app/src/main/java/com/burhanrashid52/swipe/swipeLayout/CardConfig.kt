package com.burhanrashid52.swipe.swipeLayout

/**
 * @author <a href="https://github.com/burhanrashid52">Burhanuddin Rashid</a>
 * @since 7/4/2018
 */

object CardConfig {
    /**
     * Shows the number of cards visible
     */
    const val DEFAULT_SHOW_ITEM = 3
    /**
     * The ratio of the default zoom
     */
    const val DEFAULT_SCALE = 0.1f
    /**
     * When the card Y-axis offset is calculated according to 14 divisions
     */
    const val DEFAULT_TRANSLATE_Y = 14
    /**
     * The default tilt angle when the card slides
     */
    const val DEFAULT_ROTATE_DEGREE = 15f
    /**
     * When the card slides, it is not left or right
     */
    const val SWIPING_NONE = 1
    /**
     * When the card slides to the left
     */
    const val SWIPING_LEFT = 1 shl 2
    /**
     * When the card slides to the right
     */
    const val SWIPING_RIGHT = 1 shl 3
    /**
     * The card slides out from the left
     */
    const val SWIPED_LEFT = 1
    /**
     * The card slides out from the right
     */
    const val SWIPED_RIGHT = 1 shl 2

}