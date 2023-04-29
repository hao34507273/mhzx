/*    */ package mzm.gsp.activity4.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class FlowerParadeDanceBean implements Marshal
/*    */ {
/*    */   public String tipId;
/*    */   public int actionId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.tipId = rootElement.attributeValue("tipId");
/* 15 */     this.actionId = Integer.valueOf(rootElement.attributeValue("actionId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.tipId, "UTF-8");
/* 21 */     _os_.marshal(this.actionId);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.tipId = _os_.unmarshal_String("UTF-8");
/* 28 */     this.actionId = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\FlowerParadeDanceBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */