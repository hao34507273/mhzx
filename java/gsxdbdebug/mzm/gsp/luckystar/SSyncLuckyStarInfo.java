/*    */ package mzm.gsp.luckystar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class SSyncLuckyStarInfo
/*    */   extends __SSyncLuckyStarInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12608515;
/*    */   public int activity_cfg_id;
/*    */   public ArrayList<LuckyStarAwardInfo> award_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12608515;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncLuckyStarInfo()
/*    */   {
/* 34 */     this.award_info = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSyncLuckyStarInfo(int _activity_cfg_id_, ArrayList<LuckyStarAwardInfo> _award_info_) {
/* 38 */     this.activity_cfg_id = _activity_cfg_id_;
/* 39 */     this.award_info = _award_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (LuckyStarAwardInfo _v_ : this.award_info)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activity_cfg_id);
/* 50 */     _os_.compact_uint32(this.award_info.size());
/* 51 */     for (LuckyStarAwardInfo _v_ : this.award_info) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       LuckyStarAwardInfo _v_ = new LuckyStarAwardInfo();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.award_info.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SSyncLuckyStarInfo)) {
/* 73 */       SSyncLuckyStarInfo _o_ = (SSyncLuckyStarInfo)_o1_;
/* 74 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 75 */       if (!this.award_info.equals(_o_.award_info)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.activity_cfg_id;
/* 84 */     _h_ += this.award_info.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.activity_cfg_id).append(",");
/* 92 */     _sb_.append(this.award_info).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\SSyncLuckyStarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */