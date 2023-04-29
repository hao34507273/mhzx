/*    */ package mzm.gsp.xiaohuikuaipao.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SXiaoHuiKuaiPaoGridInfo implements Marshal
/*    */ {
/*    */   public int index;
/*    */   public int activityId;
/*    */   public int hitRate;
/*    */   public int poolTypeId;
/*    */   public int weightCorrectCfgId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 17 */     this.index = Integer.valueOf(rootElement.attributeValue("index")).intValue();
/* 18 */     this.activityId = Integer.valueOf(rootElement.attributeValue("activityId")).intValue();
/* 19 */     this.hitRate = Integer.valueOf(rootElement.attributeValue("hitRate")).intValue();
/* 20 */     this.poolTypeId = Integer.valueOf(rootElement.attributeValue("poolTypeId")).intValue();
/* 21 */     this.weightCorrectCfgId = Integer.valueOf(rootElement.attributeValue("weightCorrectCfgId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 26 */     _os_.marshal(this.index);
/* 27 */     _os_.marshal(this.activityId);
/* 28 */     _os_.marshal(this.hitRate);
/* 29 */     _os_.marshal(this.poolTypeId);
/* 30 */     _os_.marshal(this.weightCorrectCfgId);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 36 */     this.index = _os_.unmarshal_int();
/* 37 */     this.activityId = _os_.unmarshal_int();
/* 38 */     this.hitRate = _os_.unmarshal_int();
/* 39 */     this.poolTypeId = _os_.unmarshal_int();
/* 40 */     this.weightCorrectCfgId = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\confbean\SXiaoHuiKuaiPaoGridInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */