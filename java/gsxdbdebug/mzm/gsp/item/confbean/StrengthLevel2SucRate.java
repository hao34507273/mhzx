/*    */ package mzm.gsp.item.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class StrengthLevel2SucRate implements Marshal
/*    */ {
/*    */   public int strengthLevel;
/*    */   public int sucRate;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.strengthLevel = Integer.valueOf(rootElement.attributeValue("strengthLevel")).intValue();
/* 15 */     this.sucRate = Integer.valueOf(rootElement.attributeValue("sucRate")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.strengthLevel);
/* 21 */     _os_.marshal(this.sucRate);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.strengthLevel = _os_.unmarshal_int();
/* 28 */     this.sucRate = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\confbean\StrengthLevel2SucRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */