/*    */ package mzm.gsp.xiaohuikuaipao.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SXiaoHuiKuaiPaoGridWeightInfo implements Marshal
/*    */ {
/*    */   public int activityId;
/*    */   public int index;
/*    */   public int itemWeight;
/*    */   public int yuanBaoWeight;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/* 17 */     this.index = Integer.valueOf(rootElement.attributeValue("index")).intValue();
/* 18 */     this.itemWeight = Integer.valueOf(rootElement.attributeValue("itemWeight")).intValue();
/* 19 */     this.yuanBaoWeight = Integer.valueOf(rootElement.attributeValue("yuanBaoWeight")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.activityId);
/* 25 */     _os_.marshal(this.index);
/* 26 */     _os_.marshal(this.itemWeight);
/* 27 */     _os_.marshal(this.yuanBaoWeight);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.activityId = _os_.unmarshal_int();
/* 34 */     this.index = _os_.unmarshal_int();
/* 35 */     this.itemWeight = _os_.unmarshal_int();
/* 36 */     this.yuanBaoWeight = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\confbean\SXiaoHuiKuaiPaoGridWeightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */