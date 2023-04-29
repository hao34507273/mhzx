/*    */ package gnet.link;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Send
/*    */   extends __Send__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 1048580;
/*    */   public HashSet<Integer> linksids;
/*    */   public int ptype;
/*    */   public Octets pdata;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 1048580;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Send()
/*    */   {
/* 33 */     this.linksids = new HashSet();
/* 34 */     this.pdata = new Octets();
/*    */   }
/*    */   
/*    */   public Send(HashSet<Integer> _linksids_, int _ptype_, Octets _pdata_) {
/* 38 */     this.linksids = _linksids_;
/* 39 */     this.ptype = _ptype_;
/* 40 */     this.pdata = _pdata_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.compact_uint32(this.linksids.size());
/* 49 */     for (Integer _v_ : this.linksids) {
/* 50 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 52 */     _os_.marshal(this.ptype);
/* 53 */     _os_.marshal(this.pdata);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 60 */       int _v_ = _os_.unmarshal_int();
/* 61 */       this.linksids.add(Integer.valueOf(_v_));
/*    */     }
/* 63 */     this.ptype = _os_.unmarshal_int();
/* 64 */     this.pdata = _os_.unmarshal_Octets();
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof Send)) {
/* 74 */       Send _o_ = (Send)_o1_;
/* 75 */       if (!this.linksids.equals(_o_.linksids)) return false;
/* 76 */       if (this.ptype != _o_.ptype) return false;
/* 77 */       if (!this.pdata.equals(_o_.pdata)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.linksids.hashCode();
/* 86 */     _h_ += this.ptype;
/* 87 */     _h_ += this.pdata.hashCode();
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.linksids).append(",");
/* 95 */     _sb_.append(this.ptype).append(",");
/* 96 */     _sb_.append("B").append(this.pdata.size()).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\link\Send.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */