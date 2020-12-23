import java.util.concurrent.CopyOnWriteArrayList;

public class MainNode {
    private volatile MainNode parent;
    private volatile int depth;
    private String url;
    private volatile CopyOnWriteArrayList<MainNode> childrens;

    public MainNode(String url) {
        depth = 0;
        this.url = url;
        parent = null;
        childrens = new CopyOnWriteArrayList<>();
    }
    private int calcDepth() {
        int result = 0;
        if (parent == null) {
            return result;
        }
        result = 1 + parent.calcDepth();
        return result;
    }

    public synchronized void addChild(MainNode element) {
        MainNode root = getRootElement();
        if(!root.contains(element.getUrl())) {
            element.setParent(this);
            childrens.add(element);
        }
    }

    private boolean contains(String url) {
        if (this.url.equals(url)) {
            return true;
        }
        for (MainNode child : childrens) {
            if(child.contains(url))
                return true;
        }

        return false;
    }

    public String getUrl() {
        return url;
    }

    private void setParent(MainNode sitemapNode) {
        synchronized (this) {
            this.parent = sitemapNode;
            this.depth = calcDepth();
        }
    }

    public MainNode getRootElement() {
        return parent == null ? this : parent.getRootElement();
    }

    public CopyOnWriteArrayList<MainNode> getChildren() {
        return childrens;
    }
}
