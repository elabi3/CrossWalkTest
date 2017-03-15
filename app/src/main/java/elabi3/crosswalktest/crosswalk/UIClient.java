package elabi3.crosswalktest.crosswalk;

import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

/**
 * Created by elabi3 on 29/4/16.
 **/
public class UIClient extends XWalkUIClient {

    /**************************************************************************
     * Constructor
     **************************************************************************/

    //region Constructor
    public UIClient(XWalkView view) {
        super(view);
    }

    //endregion


    @Override
    public boolean onConsoleMessage(XWalkView view, String message, int lineNumber, String sourceId, ConsoleMessageType messageType) {
        return super.onConsoleMessage(view, message, lineNumber, sourceId, messageType);
    }
}
