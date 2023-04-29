/*    */ package mzm.gsp.petequip.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SPetEquipPropBean implements Marshal
/*    */ {
/*    */   public int propType;
/*    */   public int propTypeHigh;
/*    */   public int propTypeLow;
/*    */   public int propTypeWight;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.propType = Integer.valueOf(rootElement.attributeValue("propType")).intValue();
/* 17 */     this.propTypeHigh = Integer.valueOf(rootElement.attributeValue("propTypeHigh")).intValue();
/* 18 */     this.propTypeLow = Integer.valueOf(rootElement.attributeValue("propTypeLow")).intValue();
/* 19 */     this.propTypeWight = Integer.valueOf(rootElement.attributeValue("propTypeWight")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.propType);
/* 25 */     _os_.marshal(this.propTypeHigh);
/* 26 */     _os_.marshal(this.propTypeLow);
/* 27 */     _os_.marshal(this.propTypeWight);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.propType = _os_.unmarshal_int();
/* 34 */     this.propTypeHigh = _os_.unmarshal_int();
/* 35 */     this.propTypeLow = _os_.unmarshal_int();
/* 36 */     this.propTypeWight = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petequip\confbean\SPetEquipPropBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */