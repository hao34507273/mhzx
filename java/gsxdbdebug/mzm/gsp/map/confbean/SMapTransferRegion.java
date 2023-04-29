/*    */ package mzm.gsp.map.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SMapTransferRegion implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int centerX;
/*    */   public int centerY;
/*    */   public int radius;
/*    */   public int targetMapCfgId;
/*    */   public int targetX;
/*    */   public int targetY;
/*    */   public boolean isActive;
/*    */   public boolean isParticular;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 21 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 22 */     this.centerX = Integer.valueOf(rootElement.attributeValue("centerX")).intValue();
/* 23 */     this.centerY = Integer.valueOf(rootElement.attributeValue("centerY")).intValue();
/* 24 */     this.radius = Integer.valueOf(rootElement.attributeValue("radius")).intValue();
/* 25 */     this.targetMapCfgId = Integer.valueOf(rootElement.attributeValue("targetMapCfgId")).intValue();
/* 26 */     this.targetX = Integer.valueOf(rootElement.attributeValue("targetX")).intValue();
/* 27 */     this.targetY = Integer.valueOf(rootElement.attributeValue("targetY")).intValue();
/* 28 */     this.isActive = Boolean.valueOf(rootElement.attributeValue("isActive")).booleanValue();
/* 29 */     this.isParticular = Boolean.valueOf(rootElement.attributeValue("isParticular")).booleanValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 34 */     _os_.marshal(this.id);
/* 35 */     _os_.marshal(this.centerX);
/* 36 */     _os_.marshal(this.centerY);
/* 37 */     _os_.marshal(this.radius);
/* 38 */     _os_.marshal(this.targetMapCfgId);
/* 39 */     _os_.marshal(this.targetX);
/* 40 */     _os_.marshal(this.targetY);
/* 41 */     _os_.marshal(this.isActive);
/* 42 */     _os_.marshal(this.isParticular);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 48 */     this.id = _os_.unmarshal_int();
/* 49 */     this.centerX = _os_.unmarshal_int();
/* 50 */     this.centerY = _os_.unmarshal_int();
/* 51 */     this.radius = _os_.unmarshal_int();
/* 52 */     this.targetMapCfgId = _os_.unmarshal_int();
/* 53 */     this.targetX = _os_.unmarshal_int();
/* 54 */     this.targetY = _os_.unmarshal_int();
/* 55 */     this.isActive = _os_.unmarshal_boolean();
/* 56 */     this.isParticular = _os_.unmarshal_boolean();
/* 57 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\confbean\SMapTransferRegion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */