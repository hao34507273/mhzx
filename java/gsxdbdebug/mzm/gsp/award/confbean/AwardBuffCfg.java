/*    */ package mzm.gsp.award.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class AwardBuffCfg implements Marshal
/*    */ {
/*    */   public int awardBuffType;
/*    */   public int buffEffId;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.awardBuffType = Integer.valueOf(rootElement.attributeValue("awardBuffType")).intValue();
/* 15 */     this.buffEffId = Integer.valueOf(rootElement.attributeValue("buffEffId")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 20 */     _os_.marshal(this.awardBuffType);
/* 21 */     _os_.marshal(this.buffEffId);
/* 22 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 27 */     this.awardBuffType = _os_.unmarshal_int();
/* 28 */     this.buffEffId = _os_.unmarshal_int();
/* 29 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\confbean\AwardBuffCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */