/*    */ package mzm.gsp.competition.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ItemController implements Marshal
/*    */ {
/*    */   public int Controller;
/*    */   public int Weight;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.Controller = Integer.valueOf(rootElement.attributeValue("Controller")).intValue();
/* 15 */     this.Weight = Integer.valueOf(rootElement.attributeValue("Weight")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.Controller);
/* 21 */     _os_.marshal(this.Weight);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.Controller = _os_.unmarshal_int();
/* 28 */     this.Weight = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\confbean\ItemController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */