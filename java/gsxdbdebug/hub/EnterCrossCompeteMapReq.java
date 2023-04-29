/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class EnterCrossCompeteMapReq
/*    */   implements Marshal
/*    */ {
/*    */   public static final int TEAM_TYPE_TEAM = 0;
/*    */   public static final int TEAM_TYPE_SINGLE_PERSON = 1;
/*    */   public long factionid;
/*    */   public ArrayList<CrossCompeteEnterRole> roles;
/*    */   public int team_type;
/*    */   
/*    */   public EnterCrossCompeteMapReq()
/*    */   {
/* 19 */     this.roles = new ArrayList();
/*    */   }
/*    */   
/*    */   public EnterCrossCompeteMapReq(long _factionid_, ArrayList<CrossCompeteEnterRole> _roles_, int _team_type_) {
/* 23 */     this.factionid = _factionid_;
/* 24 */     this.roles = _roles_;
/* 25 */     this.team_type = _team_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     for (CrossCompeteEnterRole _v_ : this.roles)
/* 30 */       if (!_v_._validator_()) return false;
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.factionid);
/* 36 */     _os_.compact_uint32(this.roles.size());
/* 37 */     for (CrossCompeteEnterRole _v_ : this.roles) {
/* 38 */       _os_.marshal(_v_);
/*    */     }
/* 40 */     _os_.marshal(this.team_type);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     this.factionid = _os_.unmarshal_long();
/* 46 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 47 */       CrossCompeteEnterRole _v_ = new CrossCompeteEnterRole();
/* 48 */       _v_.unmarshal(_os_);
/* 49 */       this.roles.add(_v_);
/*    */     }
/* 51 */     this.team_type = _os_.unmarshal_int();
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof EnterCrossCompeteMapReq)) {
/* 58 */       EnterCrossCompeteMapReq _o_ = (EnterCrossCompeteMapReq)_o1_;
/* 59 */       if (this.factionid != _o_.factionid) return false;
/* 60 */       if (!this.roles.equals(_o_.roles)) return false;
/* 61 */       if (this.team_type != _o_.team_type) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += (int)this.factionid;
/* 70 */     _h_ += this.roles.hashCode();
/* 71 */     _h_ += this.team_type;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.factionid).append(",");
/* 79 */     _sb_.append(this.roles).append(",");
/* 80 */     _sb_.append(this.team_type).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\EnterCrossCompeteMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */