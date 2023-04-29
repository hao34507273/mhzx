/*    */ package gnet.link;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UnBind
/*    */   extends __UnBind__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 1048578;
/*    */   public int pvid;
/*    */   public HashSet<Integer> linksids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 1048578;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public UnBind()
/*    */   {
/* 32 */     this.linksids = new HashSet();
/*    */   }
/*    */   
/*    */   public UnBind(int _pvid_, HashSet<Integer> _linksids_) {
/* 36 */     this.pvid = _pvid_;
/* 37 */     this.linksids = _linksids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.pvid);
/* 46 */     _os_.compact_uint32(this.linksids.size());
/* 47 */     for (Integer _v_ : this.linksids) {
/* 48 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.pvid = _os_.unmarshal_int();
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 57 */       int _v_ = _os_.unmarshal_int();
/* 58 */       this.linksids.add(Integer.valueOf(_v_));
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof UnBind)) {
/* 69 */       UnBind _o_ = (UnBind)_o1_;
/* 70 */       if (this.pvid != _o_.pvid) return false;
/* 71 */       if (!this.linksids.equals(_o_.linksids)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.pvid;
/* 80 */     _h_ += this.linksids.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.pvid).append(",");
/* 88 */     _sb_.append(this.linksids).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\UnBind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */