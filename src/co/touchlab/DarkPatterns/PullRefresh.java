package co.touchlab.DarkPatterns;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import co.touchlab.DarkPatterns.ui.PullRefreshHeaderTransformer;
import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.Options;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

/**
 * User: davidredding
 * Date: 3/11/14
 * Time: 10:51 PM
 */
public class PullRefresh extends ListActivity implements OnRefreshListener{

    private PullToRefreshLayout mPullToRefreshLayout;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pullrefresh);

        // Now find the PullToRefreshLayout to setup
        mPullToRefreshLayout = (PullToRefreshLayout) findViewById(R.id.ptr_layout);

        // Now setup the PullToRefreshLayout
        ActionBarPullToRefresh.from(this)
                .options(Options.create()
                        // Here we make the refresh scroll distance to 75% of the refreshable view's height
                        .scrollDistance(.75f)
                                // Here we define a custom header layout which will be inflated and used
                        .headerLayout(R.layout.pull_refresh_header)
                        .build())
                // Mark All Children as pullable
                .allChildrenArePullable()
                        // Set the OnRefreshListener
                .listener(this)
                        // Finally commit the setup to our PullToRefreshLayout
                .setup(mPullToRefreshLayout);

    }


    @Override
    public void onRefreshStarted(View view) {
        Toast.makeText(this, "Get more stuff!", Toast.LENGTH_SHORT).show();
    }
}