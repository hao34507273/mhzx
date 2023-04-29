/*    */ package mzm.gsp.crosscompete;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class AgainstFaction
/*    */   implements Marshal
/*    */ {
/*    */   public long factionid;
/*    */   public String faction_name;
/*    */   public int faction_level;
/*    */   public int server_level;
/*    */   public int member_count;
/*    */   
/*    */   public AgainstFaction()
/*    */   {
/* 18 */     this.faction_name = "";
/*    */   }
/*    */   
/*    */   public AgainstFaction(long _factionid_, String _faction_name_, int _faction_level_, int _server_level_, int _member_count_) {
/* 22 */     this.factionid = _factionid_;
/* 23 */     this.faction_name = _faction_name_;
/* 24 */     this.faction_level = _faction_level_;
/* 25 */     this.server_level = _server_level_;
/* 26 */     this.member_count = _member_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.factionid);
/* 35 */     _os_.marshal(this.faction_name, "UTF-16LE");
/* 36 */     _os_.marshal(this.faction_level);
/* 37 */     _os_.marshal(this.server_level);
/* 38 */     _os_.marshal(this.member_count);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     this.factionid = _os_.unmarshal_long();
/* 44 */     this.faction_name = _os_.unmarshal_String("UTF-16LE");
/* 45 */     this.faction_level = _os_.unmarshal_int();
/* 46 */     this.server_level = _os_.unmarshal_int();
/* 47 */     this.member_count = _os_.unmarshal_int();
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof AgainstFaction)) {
/* 54 */       AgainstFaction _o_ = (AgainstFaction)_o1_;
/* 55 */       if (this.factionid != _o_.factionid) return false;
/* 56 */       if (!this.faction_name.equals(_o_.faction_name)) return false;
/* 57 */       if (this.faction_level != _o_.faction_level) return false;
/* 58 */       if (this.server_level != _o_.server_level) return false;
/* 59 */       if (this.member_count != _o_.member_count) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += (int)this.factionid;
/* 68 */     _h_ += this.faction_name.hashCode();
/* 69 */     _h_ += this.faction_level;
/* 70 */     _h_ += this.server_level;
/* 71 */     _h_ += this.member_count;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.factionid).append(",");
/* 79 */     _sb_.append("T").append(this.faction_name.length()).append(",");
/* 80 */     _sb_.append(this.faction_level).append(",");
/* 81 */     _sb_.append(this.server_level).append(",");
/* 82 */     _sb_.append(this.member_count).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\AgainstFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */