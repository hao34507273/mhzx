/*    */ package mzm.gsp.floor;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class FloorFightRes implements Marshal
/*    */ {
/*    */   public ArrayList<Octets> names;
/*    */   public int killtime;
/*    */   public int usedtime;
/*    */   
/*    */   public FloorFightRes()
/*    */   {
/* 16 */     this.names = new ArrayList();
/*    */   }
/*    */   
/*    */   public FloorFightRes(ArrayList<Octets> _names_, int _killtime_, int _usedtime_) {
/* 20 */     this.names = _names_;
/* 21 */     this.killtime = _killtime_;
/* 22 */     this.usedtime = _usedtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.compact_uint32(this.names.size());
/* 31 */     for (Octets _v_ : this.names) {
/* 32 */       _os_.marshal(_v_);
/*    */     }
/* 34 */     _os_.marshal(this.killtime);
/* 35 */     _os_.marshal(this.usedtime);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 40 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 42 */       Octets _v_ = _os_.unmarshal_Octets();
/* 43 */       this.names.add(_v_);
/*    */     }
/* 45 */     this.killtime = _os_.unmarshal_int();
/* 46 */     this.usedtime = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof FloorFightRes)) {
/* 53 */       FloorFightRes _o_ = (FloorFightRes)_o1_;
/* 54 */       if (!this.names.equals(_o_.names)) return false;
/* 55 */       if (this.killtime != _o_.killtime) return false;
/* 56 */       if (this.usedtime != _o_.usedtime) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.names.hashCode();
/* 65 */     _h_ += this.killtime;
/* 66 */     _h_ += this.usedtime;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.names).append(",");
/* 74 */     _sb_.append(this.killtime).append(",");
/* 75 */     _sb_.append(this.usedtime).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\FloorFightRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */