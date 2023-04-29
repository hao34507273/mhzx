/*    */ package mzm.gsp.crosscompete;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SignedUpFaction
/*    */   implements Marshal
/*    */ {
/*    */   public long factionid;
/*    */   public String faction_name;
/*    */   public long faction_displayid;
/*    */   public long leaderid;
/*    */   public String leader_name;
/*    */   
/*    */   public SignedUpFaction()
/*    */   {
/* 18 */     this.faction_name = "";
/* 19 */     this.leader_name = "";
/*    */   }
/*    */   
/*    */   public SignedUpFaction(long _factionid_, String _faction_name_, long _faction_displayid_, long _leaderid_, String _leader_name_) {
/* 23 */     this.factionid = _factionid_;
/* 24 */     this.faction_name = _faction_name_;
/* 25 */     this.faction_displayid = _faction_displayid_;
/* 26 */     this.leaderid = _leaderid_;
/* 27 */     this.leader_name = _leader_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.factionid);
/* 36 */     _os_.marshal(this.faction_name, "UTF-16LE");
/* 37 */     _os_.marshal(this.faction_displayid);
/* 38 */     _os_.marshal(this.leaderid);
/* 39 */     _os_.marshal(this.leader_name, "UTF-16LE");
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 44 */     this.factionid = _os_.unmarshal_long();
/* 45 */     this.faction_name = _os_.unmarshal_String("UTF-16LE");
/* 46 */     this.faction_displayid = _os_.unmarshal_long();
/* 47 */     this.leaderid = _os_.unmarshal_long();
/* 48 */     this.leader_name = _os_.unmarshal_String("UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof SignedUpFaction)) {
/* 55 */       SignedUpFaction _o_ = (SignedUpFaction)_o1_;
/* 56 */       if (this.factionid != _o_.factionid) return false;
/* 57 */       if (!this.faction_name.equals(_o_.faction_name)) return false;
/* 58 */       if (this.faction_displayid != _o_.faction_displayid) return false;
/* 59 */       if (this.leaderid != _o_.leaderid) return false;
/* 60 */       if (!this.leader_name.equals(_o_.leader_name)) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += (int)this.factionid;
/* 69 */     _h_ += this.faction_name.hashCode();
/* 70 */     _h_ += (int)this.faction_displayid;
/* 71 */     _h_ += (int)this.leaderid;
/* 72 */     _h_ += this.leader_name.hashCode();
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.factionid).append(",");
/* 80 */     _sb_.append("T").append(this.faction_name.length()).append(",");
/* 81 */     _sb_.append(this.faction_displayid).append(",");
/* 82 */     _sb_.append(this.leaderid).append(",");
/* 83 */     _sb_.append("T").append(this.leader_name.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\SignedUpFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */