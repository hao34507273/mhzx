/*    */ package mzm.gsp.questionvoice.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SQuestionVoiceRewardPolicyBean implements Marshal
/*    */ {
/*    */   public int id;
/*    */   public int awardType;
/*    */   public int awardId;
/*    */   public int param_1;
/*    */   public int param_2;
/*    */   public int param_3;
/*    */   public int param_4;
/*    */   public int param_5;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 20 */     this.id = Integer.valueOf(rootElement.attributeValue("id")).intValue();
/* 21 */     this.awardType = Integer.valueOf(rootElement.attributeValue("awardType")).intValue();
/* 22 */     this.awardId = Integer.valueOf(rootElement.attributeValue("awardId")).intValue();
/* 23 */     this.param_1 = Integer.valueOf(rootElement.attributeValue("param_1")).intValue();
/* 24 */     this.param_2 = Integer.valueOf(rootElement.attributeValue("param_2")).intValue();
/* 25 */     this.param_3 = Integer.valueOf(rootElement.attributeValue("param_3")).intValue();
/* 26 */     this.param_4 = Integer.valueOf(rootElement.attributeValue("param_4")).intValue();
/* 27 */     this.param_5 = Integer.valueOf(rootElement.attributeValue("param_5")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 32 */     _os_.marshal(this.id);
/* 33 */     _os_.marshal(this.awardType);
/* 34 */     _os_.marshal(this.awardId);
/* 35 */     _os_.marshal(this.param_1);
/* 36 */     _os_.marshal(this.param_2);
/* 37 */     _os_.marshal(this.param_3);
/* 38 */     _os_.marshal(this.param_4);
/* 39 */     _os_.marshal(this.param_5);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 45 */     this.id = _os_.unmarshal_int();
/* 46 */     this.awardType = _os_.unmarshal_int();
/* 47 */     this.awardId = _os_.unmarshal_int();
/* 48 */     this.param_1 = _os_.unmarshal_int();
/* 49 */     this.param_2 = _os_.unmarshal_int();
/* 50 */     this.param_3 = _os_.unmarshal_int();
/* 51 */     this.param_4 = _os_.unmarshal_int();
/* 52 */     this.param_5 = _os_.unmarshal_int();
/* 53 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\confbean\SQuestionVoiceRewardPolicyBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */