/*    */ package mzm.gsp.award.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class ItemdropMod implements Marshal
/*    */ {
/*    */   public int itemId;
/*    */   public int weight;
/*    */   public int dropNum;
/*    */   public int dropType;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.itemId = Integer.valueOf(rootElement.attributeValue("itemId")).intValue();
/* 17 */     this.weight = Integer.valueOf(rootElement.attributeValue("weight")).intValue();
/* 18 */     this.dropNum = Integer.valueOf(rootElement.attributeValue("dropNum")).intValue();
/* 19 */     this.dropType = Integer.valueOf(rootElement.attributeValue("dropType")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.itemId);
/* 25 */     _os_.marshal(this.weight);
/* 26 */     _os_.marshal(this.dropNum);
/* 27 */     _os_.marshal(this.dropType);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.itemId = _os_.unmarshal_int();
/* 34 */     this.weight = _os_.unmarshal_int();
/* 35 */     this.dropNum = _os_.unmarshal_int();
/* 36 */     this.dropType = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\ItemdropMod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */