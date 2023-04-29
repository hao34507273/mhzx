/*    */ package mzm.gsp.marriage.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ParadeNumCfg implements Marshal
/*    */ {
/*    */   public int controlid;
/*    */   public int controlNum;
/*    */   public int x;
/*    */   public int y;
/*    */   public int protectControlid;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 17 */     this.controlid = Integer.valueOf(rootElement.attributeValue("controlid")).intValue();
/* 18 */     this.controlNum = Integer.valueOf(rootElement.attributeValue("controlNum")).intValue();
/* 19 */     this.x = Integer.valueOf(rootElement.attributeValue("x")).intValue();
/* 20 */     this.y = Integer.valueOf(rootElement.attributeValue("y")).intValue();
/* 21 */     this.protectControlid = Integer.valueOf(rootElement.attributeValue("protectControlid")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 26 */     _os_.marshal(this.controlid);
/* 27 */     _os_.marshal(this.controlNum);
/* 28 */     _os_.marshal(this.x);
/* 29 */     _os_.marshal(this.y);
/* 30 */     _os_.marshal(this.protectControlid);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 36 */     this.controlid = _os_.unmarshal_int();
/* 37 */     this.controlNum = _os_.unmarshal_int();
/* 38 */     this.x = _os_.unmarshal_int();
/* 39 */     this.y = _os_.unmarshal_int();
/* 40 */     this.protectControlid = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\confbean\ParadeNumCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */