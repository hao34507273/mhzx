/*    */ package mzm.gsp.children;
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
/*    */ public class SChildrenRefreshAmuletRes
/*    */   extends __SChildrenRefreshAmuletRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609422;
/*    */   public long childrenid;
/*    */   public ArrayList<Integer> skillids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609422;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChildrenRefreshAmuletRes()
/*    */   {
/* 34 */     this.skillids = new ArrayList();
/*    */   }
/*    */   
/*    */   public SChildrenRefreshAmuletRes(long _childrenid_, ArrayList<Integer> _skillids_) {
/* 38 */     this.childrenid = _childrenid_;
/* 39 */     this.skillids = _skillids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.childrenid);
/* 48 */     _os_.compact_uint32(this.skillids.size());
/* 49 */     for (Integer _v_ : this.skillids) {
/* 50 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.childrenid = _os_.unmarshal_long();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.skillids.add(Integer.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SChildrenRefreshAmuletRes)) {
/* 71 */       SChildrenRefreshAmuletRes _o_ = (SChildrenRefreshAmuletRes)_o1_;
/* 72 */       if (this.childrenid != _o_.childrenid) return false;
/* 73 */       if (!this.skillids.equals(_o_.skillids)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += (int)this.childrenid;
/* 82 */     _h_ += this.skillids.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.childrenid).append(",");
/* 90 */     _sb_.append(this.skillids).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SChildrenRefreshAmuletRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */