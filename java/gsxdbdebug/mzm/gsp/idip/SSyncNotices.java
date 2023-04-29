/*    */ package mzm.gsp.idip;
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
/*    */ 
/*    */ public class SSyncNotices
/*    */   extends __SSyncNotices__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12601102;
/*    */   public ArrayList<NoticeInfo> notices;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12601102;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSyncNotices()
/*    */   {
/* 33 */     this.notices = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSyncNotices(ArrayList<NoticeInfo> _notices_) {
/* 37 */     this.notices = _notices_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (NoticeInfo _v_ : this.notices)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.notices.size());
/* 48 */     for (NoticeInfo _v_ : this.notices) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       NoticeInfo _v_ = new NoticeInfo();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.notices.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSyncNotices)) {
/* 69 */       SSyncNotices _o_ = (SSyncNotices)_o1_;
/* 70 */       if (!this.notices.equals(_o_.notices)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.notices.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.notices).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\SSyncNotices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */