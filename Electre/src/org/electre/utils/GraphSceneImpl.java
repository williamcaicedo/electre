/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.electre.utils;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
//import org.neuralStudio.editor.palette.Object;

/**
 *
 * @author william
 */
public class GraphSceneImpl extends GraphScene {
    private LayerWidget mainLayer;
    private LayerWidget connectionLayer;
    //private Image nodeImage;


    public GraphSceneImpl() {
        this.mainLayer = new LayerWidget(this);
        this.connectionLayer = new LayerWidget(this);
        this.addChild(this.mainLayer);
        this.addChild(this.connectionLayer);
        /*
        this.addNode(1);
        this.addNode(2);
        Widget w1 = this.mainLayer.getChildren().get(0);
        Widget w2 = this.mainLayer.getChildren().get(1);
        this.connectNodes(w1, w2);
         *
         */

        //this.nodeImage = ImageUtilities.loadImage("org/electre/resources/node.jpg");
        /*
        this.getActions().addAction(ActionFactory.createAcceptAction(new AcceptProvider() {

            public ConnectorState isAcceptable(Widget widget, Point point, Transferable t) {
                Image dragImage = getImageFromTransferable(t);
                JComponent view = getView();
                Graphics2D g = (Graphics2D)view.getGraphics();
                Rectangle visRect = view.getVisibleRect();
                view.paintImmediately(visRect.x, visRect.y, visRect.width, visRect.height);
                g.drawImage(dragImage,AffineTransform.getTranslateInstance(point.getLocation().getX(),point.getLocation().getY()),null);
                return ConnectorState.ACCEPT;
            }

            public void accept(Widget widget, Point point, Transferable t) {
               Image image = getImageFromTransferable(t);
                Widget w = NetworkSceneImpl.this.addNode(new Object(image));
                w.setPreferredLocation(widget.convertLocalToScene(point));
            }

        }));
         *
         */
    }
    /*
    public Image getImageFromTransferable(Transferable t) {
        Object o = null;
        try {
            o = t.getTransferData(DataFlavor.imageFlavor);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (UnsupportedFlavorException ex) {
            ex.printStackTrace();
        }
        return o instanceof Image ? (Image) o : ImageUtilities.loadImage("org/neuralStudio/editor/palette/FunctionDS.jpg");
    }
    */

    public void paintElectreGraph (double[][] matrix) {
        for (int i =0; i< matrix.length; i++) {
            this.addNode(Integer.valueOf(i)+ 1);
        }
        List<Widget> widgets = this.mainLayer.getChildren();
        for (int i =0; i< matrix.length; i++) {
            Widget w1 = widgets.get(i);
            for (int j =0; j< matrix.length; j++) {
                if (i != j && matrix[i][j] == 1) {
                    Widget w2 = widgets.get(j);
                    this.connectNodes(w1, w2);
                }
            }
        }
    }
    private void connectNodes(Widget source, Widget target) {
        ConnectionWidget conn = new ConnectionWidget(this);
        conn.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);
        conn.setTargetAnchor(AnchorFactory.createRectangularAnchor(target));
        conn.setSourceAnchor(AnchorFactory.createRectangularAnchor(source));
        connectionLayer.addChild(conn);
    }
    @Override
    protected Widget attachNodeWidget(Object node) {
        Integer index = (Integer)node;
        CircleWidget widget = new CircleWidget(this,20,index.toString());
        //widget.setImage(GraphUtils.getNodeImage(index.toString()));
        //widget.setLabel(Long.toString(node.hashCode()));
        //widget.getActions().addAction(ActionFactory.createExtendedConnectAction(this.connectionLayer, new MyConnectProvider()));
        widget.getActions().addAction(ActionFactory.createMoveAction());
        //Integer col = 200*(index/3) + 10;
        double area = this.getView().getWidth();
        double area2 = this.getView().getHeight();
        int col = (int) Math.round(Math.random()*300);
        int row = (int) Math.round(Math.random()*600);
        widget.setPreferredLocation(new Point(row,col));
        mainLayer.addChild(widget);
        return widget;
    }

    @Override
    protected Widget attachEdgeWidget(Object e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void attachEdgeSourceAnchor(Object e, Object n, Object n1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void attachEdgeTargetAnchor(Object e, Object n, Object n1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private class CircleWidget extends Widget {
        private int r;
        private String label;
        public CircleWidget (Scene scene, int radius, String label) {
            super (scene);
            r = radius;
            this.label = label;
        }
        @Override
        protected Rectangle calculateClientArea () {
            return new Rectangle (- r, - r, 2 * r + 1, 2 * r + 1);
        }
        @Override
        protected void paintWidget () {
            Graphics2D g = getGraphics ();
            g.setColor (getForeground ());
            g.drawOval (- r, - r, 2 * r, 2 * r);
            g.drawString(label, r/70, r/5);
        }
    }

   





/*
    private class MyConnectProvider implements ConnectProvider{

        public boolean isSourceWidget(Widget source) {
            return source instanceof IconNodeWidget && source != null? true : false;
        }

        public ConnectorState isTargetWidget(Widget src, Widget trg) {
            return src != trg && trg instanceof IconNodeWidget ? ConnectorState.ACCEPT : ConnectorState.REJECT;
        }

        public boolean hasCustomTargetWidgetResolver(Scene arg0) {
            return false;
        }

        public Widget resolveTargetWidget(Scene arg0, Point arg1) {
            return null;
        }

        public void createConnection(Widget source, Widget target) {
            ConnectionWidget conn = new ConnectionWidget(GraphSceneImpl.this);
            conn.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);
            conn.setTargetAnchor(AnchorFactory.createRectangularAnchor(target));
            conn.setSourceAnchor(AnchorFactory.createRectangularAnchor(source));
            connectionLayer.addChild(conn);
        }
    }
*/
}