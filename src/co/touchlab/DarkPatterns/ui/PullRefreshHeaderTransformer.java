package co.touchlab.DarkPatterns.ui;

import uk.co.senab.actionbarpulltorefresh.library.HeaderTransformer;

/**
 * User: davidredding
 * Date: 3/12/14
 * Time: 12:07 PM
 */
public class PullRefreshHeaderTransformer extends HeaderTransformer {


    @Override
    public boolean showHeaderView() {
        return false;
    }

    @Override
    public boolean hideHeaderView() {
        return false;
    }
}
