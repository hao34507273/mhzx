/*    */ package mzm.gsp.friend;
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
/*    */ public class SSynApplyList
/*    */   extends __SSynApplyList__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587013;
/*    */   public ArrayList<StrangerInfo> applylist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12587013;
/*    */   }
/*    */   
/*    */ 
/*    */   public SSynApplyList()
/*    */   {
/* 31 */     this.applylist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynApplyList(ArrayList<StrangerInfo> _applylist_) {
/* 35 */     this.applylist = _applylist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     for (StrangerInfo _v_ : this.applylist)
/* 40 */       if (!_v_._validator_()) return false;
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.applylist.size());
/* 46 */     for (StrangerInfo _v_ : this.applylist) {
/* 47 */       _os_.marshal(_v_);
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 54 */       StrangerInfo _v_ = new StrangerInfo();
/* 55 */       _v_.unmarshal(_os_);
/* 56 */       this.applylist.add(_v_);
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SSynApplyList)) {
/* 67 */       SSynApplyList _o_ = (SSynApplyList)_o1_;
/* 68 */       if (!this.applylist.equals(_o_.applylist)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.applylist.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.applylist).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\SSynApplyList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */