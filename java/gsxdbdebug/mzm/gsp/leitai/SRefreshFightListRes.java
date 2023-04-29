/*    */ package mzm.gsp.leitai;
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
/*    */ public class SRefreshFightListRes
/*    */   extends __SRefreshFightListRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591880;
/*    */   public ArrayList<LeiTaiFightInfo> leitaifightinfolist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591880;
/*    */   }
/*    */   
/*    */ 
/*    */   public SRefreshFightListRes()
/*    */   {
/* 33 */     this.leitaifightinfolist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SRefreshFightListRes(ArrayList<LeiTaiFightInfo> _leitaifightinfolist_) {
/* 37 */     this.leitaifightinfolist = _leitaifightinfolist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (LeiTaiFightInfo _v_ : this.leitaifightinfolist)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.leitaifightinfolist.size());
/* 48 */     for (LeiTaiFightInfo _v_ : this.leitaifightinfolist) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       LeiTaiFightInfo _v_ = new LeiTaiFightInfo();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.leitaifightinfolist.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SRefreshFightListRes)) {
/* 69 */       SRefreshFightListRes _o_ = (SRefreshFightListRes)_o1_;
/* 70 */       if (!this.leitaifightinfolist.equals(_o_.leitaifightinfolist)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.leitaifightinfolist.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.leitaifightinfolist).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\leitai\SRefreshFightListRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */