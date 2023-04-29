/*    */ package mzm.gsp.mounts.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class MountsDyeColorBean implements Marshal
/*    */ {
/*    */   public int colorId;
/*    */   public int itemId;
/*    */   public int costItemType;
/*    */   public int itemCount;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.colorId = Integer.valueOf(rootElement.attributeValue("colorId")).intValue();
/* 17 */     this.itemId = Integer.valueOf(rootElement.attributeValue("itemId")).intValue();
/* 18 */     this.costItemType = Integer.valueOf(rootElement.attributeValue("costItemType")).intValue();
/* 19 */     this.itemCount = Integer.valueOf(rootElement.attributeValue("itemCount")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.colorId);
/* 25 */     _os_.marshal(this.itemId);
/* 26 */     _os_.marshal(this.costItemType);
/* 27 */     _os_.marshal(this.itemCount);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.colorId = _os_.unmarshal_int();
/* 34 */     this.itemId = _os_.unmarshal_int();
/* 35 */     this.costItemType = _os_.unmarshal_int();
/* 36 */     this.itemCount = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\confbean\MountsDyeColorBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */