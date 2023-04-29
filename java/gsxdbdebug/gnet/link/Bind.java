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
/*    */ 
/*    */ 
/*    */ public class Bind
/*    */   extends __Bind__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 1048577;
/*    */   public int pvid;
/*    */   public HashSet<Integer> linksids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 1048577;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Bind()
/*    */   {
/* 34 */     this.linksids = new HashSet();
/*    */   }
/*    */   
/*    */   public Bind(int _pvid_, HashSet<Integer> _linksids_) {
/* 38 */     this.pvid = _pvid_;
/* 39 */     this.linksids = _linksids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.pvid);
/* 48 */     _os_.compact_uint32(this.linksids.size());
/* 49 */     for (Integer _v_ : this.linksids) {
/* 50 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.pvid = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.linksids.add(Integer.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof Bind)) {
/* 71 */       Bind _o_ = (Bind)_o1_;
/* 72 */       if (this.pvid != _o_.pvid) return false;
/* 73 */       if (!this.linksids.equals(_o_.linksids)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.pvid;
/* 82 */     _h_ += this.linksids.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.pvid).append(",");
/* 90 */     _sb_.append(this.linksids).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\Bind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */