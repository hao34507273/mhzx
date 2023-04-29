/*    */ package gnet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class RegisGameServerArg implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<Integer> serverids;
/*    */   public int version;
/*    */   public int reserved1;
/*    */   public com.goldhuman.Common.Octets reserved2;
/*    */   
/*    */   public RegisGameServerArg()
/*    */   {
/* 15 */     this.serverids = new ArrayList();
/* 16 */     this.reserved2 = new com.goldhuman.Common.Octets();
/*    */   }
/*    */   
/*    */   public RegisGameServerArg(ArrayList<Integer> _serverids_, int _version_, int _reserved1_, com.goldhuman.Common.Octets _reserved2_) {
/* 20 */     this.serverids = _serverids_;
/* 21 */     this.version = _version_;
/* 22 */     this.reserved1 = _reserved1_;
/* 23 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.compact_uint32(this.serverids.size());
/* 32 */     for (Integer _v_ : this.serverids) {
/* 33 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 35 */     _os_.marshal(this.version);
/* 36 */     _os_.marshal(this.reserved1);
/* 37 */     _os_.marshal(this.reserved2);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 42 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 44 */       int _v_ = _os_.unmarshal_int();
/* 45 */       this.serverids.add(Integer.valueOf(_v_));
/*    */     }
/* 47 */     this.version = _os_.unmarshal_int();
/* 48 */     this.reserved1 = _os_.unmarshal_int();
/* 49 */     this.reserved2 = _os_.unmarshal_Octets();
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof RegisGameServerArg)) {
/* 56 */       RegisGameServerArg _o_ = (RegisGameServerArg)_o1_;
/* 57 */       if (!this.serverids.equals(_o_.serverids)) return false;
/* 58 */       if (this.version != _o_.version) return false;
/* 59 */       if (this.reserved1 != _o_.reserved1) return false;
/* 60 */       if (!this.reserved2.equals(_o_.reserved2)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.serverids.hashCode();
/* 69 */     _h_ += this.version;
/* 70 */     _h_ += this.reserved1;
/* 71 */     _h_ += this.reserved2.hashCode();
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.serverids).append(",");
/* 79 */     _sb_.append(this.version).append(",");
/* 80 */     _sb_.append(this.reserved1).append(",");
/* 81 */     _sb_.append("B").append(this.reserved2.size()).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\gnet\RegisGameServerArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */