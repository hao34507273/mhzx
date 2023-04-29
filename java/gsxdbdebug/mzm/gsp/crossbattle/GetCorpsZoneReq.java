/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class GetCorpsZoneReq implements Marshal
/*    */ {
/*    */   public int activity_cfgid;
/*    */   public ArrayList<Long> corpsids;
/*    */   public Octets context;
/*    */   
/*    */   public GetCorpsZoneReq()
/*    */   {
/* 16 */     this.corpsids = new ArrayList();
/* 17 */     this.context = new Octets();
/*    */   }
/*    */   
/*    */   public GetCorpsZoneReq(int _activity_cfgid_, ArrayList<Long> _corpsids_, Octets _context_) {
/* 21 */     this.activity_cfgid = _activity_cfgid_;
/* 22 */     this.corpsids = _corpsids_;
/* 23 */     this.context = _context_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.activity_cfgid);
/* 32 */     _os_.compact_uint32(this.corpsids.size());
/* 33 */     for (Long _v_ : this.corpsids) {
/* 34 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 36 */     _os_.marshal(this.context);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.activity_cfgid = _os_.unmarshal_int();
/* 42 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 44 */       long _v_ = _os_.unmarshal_long();
/* 45 */       this.corpsids.add(Long.valueOf(_v_));
/*    */     }
/* 47 */     this.context = _os_.unmarshal_Octets();
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof GetCorpsZoneReq)) {
/* 54 */       GetCorpsZoneReq _o_ = (GetCorpsZoneReq)_o1_;
/* 55 */       if (this.activity_cfgid != _o_.activity_cfgid) return false;
/* 56 */       if (!this.corpsids.equals(_o_.corpsids)) return false;
/* 57 */       if (!this.context.equals(_o_.context)) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.activity_cfgid;
/* 66 */     _h_ += this.corpsids.hashCode();
/* 67 */     _h_ += this.context.hashCode();
/* 68 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder _sb_ = new StringBuilder();
/* 73 */     _sb_.append("(");
/* 74 */     _sb_.append(this.activity_cfgid).append(",");
/* 75 */     _sb_.append(this.corpsids).append(",");
/* 76 */     _sb_.append("B").append(this.context.size()).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetCorpsZoneReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */