/*    */ package mzm.gsp.children.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class QualityInfo implements Marshal
/*    */ {
/*    */   public int qualityType;
/*    */   public int min;
/*    */   public int max;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 15 */     this.qualityType = Integer.valueOf(rootElement.attributeValue("qualityType")).intValue();
/* 16 */     this.min = Integer.valueOf(rootElement.attributeValue("min")).intValue();
/* 17 */     this.max = Integer.valueOf(rootElement.attributeValue("max")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 22 */     _os_.marshal(this.qualityType);
/* 23 */     _os_.marshal(this.min);
/* 24 */     _os_.marshal(this.max);
/* 25 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 30 */     this.qualityType = _os_.unmarshal_int();
/* 31 */     this.min = _os_.unmarshal_int();
/* 32 */     this.max = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\confbean\QualityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */