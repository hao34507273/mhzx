/*    */ package mzm.gsp.fabaolingqi.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ArtifactProperty implements Marshal
/*    */ {
/*    */   public int initValue;
/*    */   public int finalValue;
/*    */   public int improvedValue;
/*    */   public int itemFilterId;
/*    */   public int itemNum;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 17 */     this.initValue = Integer.valueOf(rootElement.attributeValue("initValue")).intValue();
/* 18 */     this.finalValue = Integer.valueOf(rootElement.attributeValue("finalValue")).intValue();
/* 19 */     this.improvedValue = Integer.valueOf(rootElement.attributeValue("improvedValue")).intValue();
/* 20 */     this.itemFilterId = Integer.valueOf(rootElement.attributeValue("itemFilterId")).intValue();
/* 21 */     this.itemNum = Integer.valueOf(rootElement.attributeValue("itemNum")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 26 */     _os_.marshal(this.initValue);
/* 27 */     _os_.marshal(this.finalValue);
/* 28 */     _os_.marshal(this.improvedValue);
/* 29 */     _os_.marshal(this.itemFilterId);
/* 30 */     _os_.marshal(this.itemNum);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 36 */     this.initValue = _os_.unmarshal_int();
/* 37 */     this.finalValue = _os_.unmarshal_int();
/* 38 */     this.improvedValue = _os_.unmarshal_int();
/* 39 */     this.itemFilterId = _os_.unmarshal_int();
/* 40 */     this.itemNum = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\confbean\ArtifactProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */