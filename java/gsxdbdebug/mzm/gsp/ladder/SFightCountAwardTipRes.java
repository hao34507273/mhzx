/*    */ package mzm.gsp.ladder;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.award.AwardBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SFightCountAwardTipRes
/*    */   extends __SFightCountAwardTipRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12607261;
/*    */   public AwardBean fightcountawardinfo;
/*    */   public int count;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12607261;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFightCountAwardTipRes()
/*    */   {
/* 34 */     this.fightcountawardinfo = new AwardBean();
/*    */   }
/*    */   
/*    */   public SFightCountAwardTipRes(AwardBean _fightcountawardinfo_, int _count_) {
/* 38 */     this.fightcountawardinfo = _fightcountawardinfo_;
/* 39 */     this.count = _count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.fightcountawardinfo._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.fightcountawardinfo);
/* 49 */     _os_.marshal(this.count);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.fightcountawardinfo.unmarshal(_os_);
/* 55 */     this.count = _os_.unmarshal_int();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SFightCountAwardTipRes)) {
/* 65 */       SFightCountAwardTipRes _o_ = (SFightCountAwardTipRes)_o1_;
/* 66 */       if (!this.fightcountawardinfo.equals(_o_.fightcountawardinfo)) return false;
/* 67 */       if (this.count != _o_.count) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.fightcountawardinfo.hashCode();
/* 76 */     _h_ += this.count;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.fightcountawardinfo).append(",");
/* 84 */     _sb_.append(this.count).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\SFightCountAwardTipRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */