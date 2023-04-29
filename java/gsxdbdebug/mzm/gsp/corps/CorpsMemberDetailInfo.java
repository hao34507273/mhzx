/*    */ package mzm.gsp.corps;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class CorpsMemberDetailInfo
/*    */   implements Marshal
/*    */ {
/*    */   public CorpsMember baseinfo;
/*    */   public CorpsMemberOtherInfo otherinfo;
/*    */   
/*    */   public CorpsMemberDetailInfo()
/*    */   {
/* 15 */     this.baseinfo = new CorpsMember();
/* 16 */     this.otherinfo = new CorpsMemberOtherInfo();
/*    */   }
/*    */   
/*    */   public CorpsMemberDetailInfo(CorpsMember _baseinfo_, CorpsMemberOtherInfo _otherinfo_) {
/* 20 */     this.baseinfo = _baseinfo_;
/* 21 */     this.otherinfo = _otherinfo_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     if (!this.baseinfo._validator_()) return false;
/* 26 */     if (!this.otherinfo._validator_()) return false;
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.baseinfo);
/* 32 */     _os_.marshal(this.otherinfo);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.baseinfo.unmarshal(_os_);
/* 38 */     this.otherinfo.unmarshal(_os_);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof CorpsMemberDetailInfo)) {
/* 45 */       CorpsMemberDetailInfo _o_ = (CorpsMemberDetailInfo)_o1_;
/* 46 */       if (!this.baseinfo.equals(_o_.baseinfo)) return false;
/* 47 */       if (!this.otherinfo.equals(_o_.otherinfo)) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += this.baseinfo.hashCode();
/* 56 */     _h_ += this.otherinfo.hashCode();
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.baseinfo).append(",");
/* 64 */     _sb_.append(this.otherinfo).append(",");
/* 65 */     _sb_.append(")");
/* 66 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\CorpsMemberDetailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */