/*    */ package mzm.gsp.activity4.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SFlowerParadeOcpCfg implements Marshal
/*    */ {
/*    */   public int radius;
/*    */   public int ocpRole1;
/*    */   public int ocpRole2;
/*    */   public int chosenTime;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.radius = Integer.valueOf(rootElement.attributeValue("radius")).intValue();
/* 17 */     this.ocpRole1 = Integer.valueOf(rootElement.attributeValue("ocpRole1")).intValue();
/* 18 */     this.ocpRole2 = Integer.valueOf(rootElement.attributeValue("ocpRole2")).intValue();
/* 19 */     this.chosenTime = Integer.valueOf(rootElement.attributeValue("chosenTime")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.radius);
/* 25 */     _os_.marshal(this.ocpRole1);
/* 26 */     _os_.marshal(this.ocpRole2);
/* 27 */     _os_.marshal(this.chosenTime);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.radius = _os_.unmarshal_int();
/* 34 */     this.ocpRole1 = _os_.unmarshal_int();
/* 35 */     this.ocpRole2 = _os_.unmarshal_int();
/* 36 */     this.chosenTime = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SFlowerParadeOcpCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */