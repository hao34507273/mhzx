/*    */ package mzm.gsp.zhenfa.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class PosAttriBean implements Marshal
/*    */ {
/*    */   public int posAEffect;
/*    */   public int posAInitValue;
/*    */   public int posAGrowValue;
/*    */   public int posBEffect;
/*    */   public int posBInitValue;
/*    */   public int posBGrowValue;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 18 */     this.posAEffect = Integer.valueOf(rootElement.attributeValue("posAEffect")).intValue();
/* 19 */     this.posAInitValue = Integer.valueOf(rootElement.attributeValue("posAInitValue")).intValue();
/* 20 */     this.posAGrowValue = Integer.valueOf(rootElement.attributeValue("posAGrowValue")).intValue();
/* 21 */     this.posBEffect = Integer.valueOf(rootElement.attributeValue("posBEffect")).intValue();
/* 22 */     this.posBInitValue = Integer.valueOf(rootElement.attributeValue("posBInitValue")).intValue();
/* 23 */     this.posBGrowValue = Integer.valueOf(rootElement.attributeValue("posBGrowValue")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 28 */     _os_.marshal(this.posAEffect);
/* 29 */     _os_.marshal(this.posAInitValue);
/* 30 */     _os_.marshal(this.posAGrowValue);
/* 31 */     _os_.marshal(this.posBEffect);
/* 32 */     _os_.marshal(this.posBInitValue);
/* 33 */     _os_.marshal(this.posBGrowValue);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 39 */     this.posAEffect = _os_.unmarshal_int();
/* 40 */     this.posAInitValue = _os_.unmarshal_int();
/* 41 */     this.posAGrowValue = _os_.unmarshal_int();
/* 42 */     this.posBEffect = _os_.unmarshal_int();
/* 43 */     this.posBInitValue = _os_.unmarshal_int();
/* 44 */     this.posBGrowValue = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenfa\confbean\PosAttriBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */