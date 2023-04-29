/*    */ package mzm.gsp.crosscompete.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ItemController implements Marshal
/*    */ {
/*    */   public int Controller;
/*    */   public int Weight;
/*    */   public int TreasureMapItem;
/*    */   public int TreasureAward;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.Controller = Integer.valueOf(rootElement.attributeValue("Controller")).intValue();
/* 17 */     this.Weight = Integer.valueOf(rootElement.attributeValue("Weight")).intValue();
/* 18 */     this.TreasureMapItem = Integer.valueOf(rootElement.attributeValue("TreasureMapItem")).intValue();
/* 19 */     this.TreasureAward = Integer.valueOf(rootElement.attributeValue("TreasureAward")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.Controller);
/* 25 */     _os_.marshal(this.Weight);
/* 26 */     _os_.marshal(this.TreasureMapItem);
/* 27 */     _os_.marshal(this.TreasureAward);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.Controller = _os_.unmarshal_int();
/* 34 */     this.Weight = _os_.unmarshal_int();
/* 35 */     this.TreasureMapItem = _os_.unmarshal_int();
/* 36 */     this.TreasureAward = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\confbean\ItemController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */