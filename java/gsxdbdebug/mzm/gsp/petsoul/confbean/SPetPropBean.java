/*    */ package mzm.gsp.petsoul.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SPetPropBean implements Marshal
/*    */ {
/*    */   public int propType;
/*    */   public int propValue;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.propType = Integer.valueOf(rootElement.attributeValue("propType")).intValue();
/* 15 */     this.propValue = Integer.valueOf(rootElement.attributeValue("propValue")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.propType);
/* 21 */     _os_.marshal(this.propValue);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.propType = _os_.unmarshal_int();
/* 28 */     this.propValue = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petsoul\confbean\SPetPropBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */