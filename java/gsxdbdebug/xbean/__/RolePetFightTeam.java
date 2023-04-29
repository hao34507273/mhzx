/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class RolePetFightTeam extends XBean implements xbean.RolePetFightTeam
/*     */ {
/*     */   private int defense_team;
/*     */   private HashMap<Integer, xbean.PetFightTeamInfo> team_info;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.defense_team = -1;
/*  21 */     this.team_info.clear();
/*     */   }
/*     */   
/*     */   RolePetFightTeam(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.defense_team = -1;
/*  28 */     this.team_info = new HashMap();
/*     */   }
/*     */   
/*     */   public RolePetFightTeam()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RolePetFightTeam(RolePetFightTeam _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RolePetFightTeam(xbean.RolePetFightTeam _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof RolePetFightTeam)) { assign((RolePetFightTeam)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RolePetFightTeam _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.defense_team = _o_.defense_team;
/*  54 */     this.team_info = new HashMap();
/*  55 */     for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : _o_.team_info.entrySet()) {
/*  56 */       this.team_info.put(_e_.getKey(), new PetFightTeamInfo((xbean.PetFightTeamInfo)_e_.getValue(), this, "team_info"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  61 */     this.defense_team = _o_.defense_team;
/*  62 */     this.team_info = new HashMap();
/*  63 */     for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : _o_.team_info.entrySet()) {
/*  64 */       this.team_info.put(_e_.getKey(), new PetFightTeamInfo((xbean.PetFightTeamInfo)_e_.getValue(), this, "team_info"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.defense_team);
/*  72 */     _os_.compact_uint32(this.team_info.size());
/*  73 */     for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : this.team_info.entrySet())
/*     */     {
/*  75 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  76 */       ((xbean.PetFightTeamInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     this.defense_team = _os_.unmarshal_int();
/*     */     
/*  87 */     int size = _os_.uncompact_uint32();
/*  88 */     if (size >= 12)
/*     */     {
/*  90 */       this.team_info = new HashMap(size * 2);
/*     */     }
/*  92 */     for (; size > 0; size--)
/*     */     {
/*  94 */       int _k_ = 0;
/*  95 */       _k_ = _os_.unmarshal_int();
/*  96 */       xbean.PetFightTeamInfo _v_ = new PetFightTeamInfo(0, this, "team_info");
/*  97 */       _v_.unmarshal(_os_);
/*  98 */       this.team_info.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     _size_ += CodedOutputStream.computeInt32Size(1, this.defense_team);
/* 110 */     for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : this.team_info.entrySet())
/*     */     {
/* 112 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 113 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */     }
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       _output_.writeInt32(1, this.defense_team);
/* 125 */       for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : this.team_info.entrySet())
/*     */       {
/* 127 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 128 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 133 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 135 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 144 */       boolean done = false;
/* 145 */       while (!done)
/*     */       {
/* 147 */         int tag = _input_.readTag();
/* 148 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 152 */           done = true;
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 157 */           this.defense_team = _input_.readInt32();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 162 */           int _k_ = 0;
/* 163 */           _k_ = _input_.readInt32();
/* 164 */           int readTag = _input_.readTag();
/* 165 */           if (18 != readTag)
/*     */           {
/* 167 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 169 */           xbean.PetFightTeamInfo _v_ = new PetFightTeamInfo(0, this, "team_info");
/* 170 */           _input_.readMessage(_v_);
/* 171 */           this.team_info.put(Integer.valueOf(_k_), _v_);
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RolePetFightTeam copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new RolePetFightTeam(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RolePetFightTeam toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RolePetFightTeam toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new RolePetFightTeam(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RolePetFightTeam toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RolePetFightTeam toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDefense_team()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.defense_team;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.PetFightTeamInfo> getTeam_info()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return xdb.Logs.logMap(new xdb.LogKey(this, "team_info"), this.team_info);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.PetFightTeamInfo> getTeam_infoAsData()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/*     */     
/* 258 */     RolePetFightTeam _o_ = this;
/* 259 */     Map<Integer, xbean.PetFightTeamInfo> team_info = new HashMap();
/* 260 */     for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : _o_.team_info.entrySet())
/* 261 */       team_info.put(_e_.getKey(), new PetFightTeamInfo.Data((xbean.PetFightTeamInfo)_e_.getValue()));
/* 262 */     return team_info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDefense_team(int _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "defense_team")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogInt(this, RolePetFightTeam.this.defense_team)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             RolePetFightTeam.this.defense_team = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.defense_team = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     RolePetFightTeam _o_ = null;
/* 291 */     if ((_o1_ instanceof RolePetFightTeam)) { _o_ = (RolePetFightTeam)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (this.defense_team != _o_.defense_team) return false;
/* 295 */     if (!this.team_info.equals(_o_.team_info)) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ += this.defense_team;
/* 305 */     _h_ += this.team_info.hashCode();
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.defense_team);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.team_info);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableChanged().setVarName("defense_team"));
/* 327 */     lb.add(new xdb.logs.ListenableMap().setVarName("team_info"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RolePetFightTeam {
/*     */     private Const() {}
/*     */     
/*     */     RolePetFightTeam nThis() {
/* 335 */       return RolePetFightTeam.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightTeam copy()
/*     */     {
/* 347 */       return RolePetFightTeam.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightTeam toData()
/*     */     {
/* 353 */       return RolePetFightTeam.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RolePetFightTeam toBean()
/*     */     {
/* 358 */       return RolePetFightTeam.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightTeam toDataIf()
/*     */     {
/* 364 */       return RolePetFightTeam.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RolePetFightTeam toBeanIf()
/*     */     {
/* 369 */       return RolePetFightTeam.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDefense_team()
/*     */     {
/* 376 */       RolePetFightTeam.this._xdb_verify_unsafe_();
/* 377 */       return RolePetFightTeam.this.defense_team;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.PetFightTeamInfo> getTeam_info()
/*     */     {
/* 384 */       RolePetFightTeam.this._xdb_verify_unsafe_();
/* 385 */       return xdb.Consts.constMap(RolePetFightTeam.this.team_info);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.PetFightTeamInfo> getTeam_infoAsData()
/*     */     {
/* 392 */       RolePetFightTeam.this._xdb_verify_unsafe_();
/*     */       
/* 394 */       RolePetFightTeam _o_ = RolePetFightTeam.this;
/* 395 */       Map<Integer, xbean.PetFightTeamInfo> team_info = new HashMap();
/* 396 */       for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : _o_.team_info.entrySet())
/* 397 */         team_info.put(_e_.getKey(), new PetFightTeamInfo.Data((xbean.PetFightTeamInfo)_e_.getValue()));
/* 398 */       return team_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDefense_team(int _v_)
/*     */     {
/* 405 */       RolePetFightTeam.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       RolePetFightTeam.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       RolePetFightTeam.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return RolePetFightTeam.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return RolePetFightTeam.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       RolePetFightTeam.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return RolePetFightTeam.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return RolePetFightTeam.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       RolePetFightTeam.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return RolePetFightTeam.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return RolePetFightTeam.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return RolePetFightTeam.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return RolePetFightTeam.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return RolePetFightTeam.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return RolePetFightTeam.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return RolePetFightTeam.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RolePetFightTeam
/*     */   {
/*     */     private int defense_team;
/*     */     
/*     */     private HashMap<Integer, xbean.PetFightTeamInfo> team_info;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.defense_team = -1;
/* 520 */       this.team_info = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RolePetFightTeam _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof RolePetFightTeam)) { assign((RolePetFightTeam)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof RolePetFightTeam.Const)) assign(((RolePetFightTeam.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RolePetFightTeam _o_) {
/* 533 */       this.defense_team = _o_.defense_team;
/* 534 */       this.team_info = new HashMap();
/* 535 */       for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : _o_.team_info.entrySet()) {
/* 536 */         this.team_info.put(_e_.getKey(), new PetFightTeamInfo.Data((xbean.PetFightTeamInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 541 */       this.defense_team = _o_.defense_team;
/* 542 */       this.team_info = new HashMap();
/* 543 */       for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : _o_.team_info.entrySet()) {
/* 544 */         this.team_info.put(_e_.getKey(), new PetFightTeamInfo.Data((xbean.PetFightTeamInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.marshal(this.defense_team);
/* 551 */       _os_.compact_uint32(this.team_info.size());
/* 552 */       for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : this.team_info.entrySet())
/*     */       {
/* 554 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 555 */         ((xbean.PetFightTeamInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 563 */       this.defense_team = _os_.unmarshal_int();
/*     */       
/* 565 */       int size = _os_.uncompact_uint32();
/* 566 */       if (size >= 12)
/*     */       {
/* 568 */         this.team_info = new HashMap(size * 2);
/*     */       }
/* 570 */       for (; size > 0; size--)
/*     */       {
/* 572 */         int _k_ = 0;
/* 573 */         _k_ = _os_.unmarshal_int();
/* 574 */         xbean.PetFightTeamInfo _v_ = xbean.Pod.newPetFightTeamInfoData();
/* 575 */         _v_.unmarshal(_os_);
/* 576 */         this.team_info.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       _size_ += CodedOutputStream.computeInt32Size(1, this.defense_team);
/* 587 */       for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : this.team_info.entrySet())
/*     */       {
/* 589 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 590 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*     */       }
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         _output_.writeInt32(1, this.defense_team);
/* 601 */         for (Map.Entry<Integer, xbean.PetFightTeamInfo> _e_ : this.team_info.entrySet())
/*     */         {
/* 603 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 604 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.defense_team = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             int _k_ = 0;
/* 638 */             _k_ = _input_.readInt32();
/* 639 */             int readTag = _input_.readTag();
/* 640 */             if (18 != readTag)
/*     */             {
/* 642 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 644 */             xbean.PetFightTeamInfo _v_ = xbean.Pod.newPetFightTeamInfoData();
/* 645 */             _input_.readMessage(_v_);
/* 646 */             this.team_info.put(Integer.valueOf(_k_), _v_);
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightTeam copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightTeam toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RolePetFightTeam toBean()
/*     */     {
/* 685 */       return new RolePetFightTeam(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RolePetFightTeam toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RolePetFightTeam toBeanIf()
/*     */     {
/* 696 */       return new RolePetFightTeam(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDefense_team()
/*     */     {
/* 733 */       return this.defense_team;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.PetFightTeamInfo> getTeam_info()
/*     */     {
/* 740 */       return this.team_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.PetFightTeamInfo> getTeam_infoAsData()
/*     */     {
/* 747 */       return this.team_info;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDefense_team(int _v_)
/*     */     {
/* 754 */       this.defense_team = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (this.defense_team != _o_.defense_team) return false;
/* 763 */       if (!this.team_info.equals(_o_.team_info)) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ += this.defense_team;
/* 772 */       _h_ += this.team_info.hashCode();
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.defense_team);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.team_info);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RolePetFightTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */