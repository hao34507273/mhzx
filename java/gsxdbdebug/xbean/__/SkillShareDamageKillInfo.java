/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class SkillShareDamageKillInfo extends XBean implements xbean.SkillShareDamageKillInfo
/*     */ {
/*     */   private int sharedamagetype;
/*     */   private int sharedamagefighterid;
/*     */   private int skillid;
/*     */   private int fighterid;
/*     */   private long roleid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  26 */     this.sharedamagetype = 0;
/*  27 */     this.sharedamagefighterid = 0;
/*  28 */     this.skillid = 0;
/*  29 */     this.fighterid = 0;
/*  30 */     this.roleid = 0L;
/*     */   }
/*     */   
/*     */   SkillShareDamageKillInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  35 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public SkillShareDamageKillInfo()
/*     */   {
/*  40 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public SkillShareDamageKillInfo(SkillShareDamageKillInfo _o_)
/*     */   {
/*  45 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   SkillShareDamageKillInfo(xbean.SkillShareDamageKillInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     if ((_o1_ instanceof SkillShareDamageKillInfo)) { assign((SkillShareDamageKillInfo)_o1_);
/*  52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  54 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(SkillShareDamageKillInfo _o_) {
/*  59 */     _o_._xdb_verify_unsafe_();
/*  60 */     this.sharedamagetype = _o_.sharedamagetype;
/*  61 */     this.sharedamagefighterid = _o_.sharedamagefighterid;
/*  62 */     this.skillid = _o_.skillid;
/*  63 */     this.fighterid = _o_.fighterid;
/*  64 */     this.roleid = _o_.roleid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.sharedamagetype = _o_.sharedamagetype;
/*  70 */     this.sharedamagefighterid = _o_.sharedamagefighterid;
/*  71 */     this.skillid = _o_.skillid;
/*  72 */     this.fighterid = _o_.fighterid;
/*  73 */     this.roleid = _o_.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.sharedamagetype);
/*  81 */     _os_.marshal(this.sharedamagefighterid);
/*  82 */     _os_.marshal(this.skillid);
/*  83 */     _os_.marshal(this.fighterid);
/*  84 */     _os_.marshal(this.roleid);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.sharedamagetype = _os_.unmarshal_int();
/*  93 */     this.sharedamagefighterid = _os_.unmarshal_int();
/*  94 */     this.skillid = _os_.unmarshal_int();
/*  95 */     this.fighterid = _os_.unmarshal_int();
/*  96 */     this.roleid = _os_.unmarshal_long();
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     int _size_ = 0;
/* 105 */     _size_ += CodedOutputStream.computeInt32Size(1, this.sharedamagetype);
/* 106 */     _size_ += CodedOutputStream.computeInt32Size(2, this.sharedamagefighterid);
/* 107 */     _size_ += CodedOutputStream.computeInt32Size(3, this.skillid);
/* 108 */     _size_ += CodedOutputStream.computeInt32Size(4, this.fighterid);
/* 109 */     _size_ += CodedOutputStream.computeInt64Size(5, this.roleid);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt32(1, this.sharedamagetype);
/* 120 */       _output_.writeInt32(2, this.sharedamagefighterid);
/* 121 */       _output_.writeInt32(3, this.skillid);
/* 122 */       _output_.writeInt32(4, this.fighterid);
/* 123 */       _output_.writeInt64(5, this.roleid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 127 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 129 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       boolean done = false;
/* 139 */       while (!done)
/*     */       {
/* 141 */         int tag = _input_.readTag();
/* 142 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 146 */           done = true;
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 151 */           this.sharedamagetype = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           this.sharedamagefighterid = _input_.readInt32();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 161 */           this.skillid = _input_.readInt32();
/* 162 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 166 */           this.fighterid = _input_.readInt32();
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 171 */           this.roleid = _input_.readInt64();
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
/*     */   public xbean.SkillShareDamageKillInfo copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new SkillShareDamageKillInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillShareDamageKillInfo toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SkillShareDamageKillInfo toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new SkillShareDamageKillInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.SkillShareDamageKillInfo toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.SkillShareDamageKillInfo toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSharedamagetype()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.sharedamagetype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSharedamagefighterid()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return this.sharedamagefighterid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSkillid()
/*     */   {
/* 256 */     _xdb_verify_unsafe_();
/* 257 */     return this.skillid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getFighterid()
/*     */   {
/* 264 */     _xdb_verify_unsafe_();
/* 265 */     return this.fighterid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSharedamagetype(int _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "sharedamagetype")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 285 */         new LogInt(this, SkillShareDamageKillInfo.this.sharedamagetype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             SkillShareDamageKillInfo.this.sharedamagetype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.sharedamagetype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSharedamagefighterid(int _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "sharedamagefighterid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 306 */         new LogInt(this, SkillShareDamageKillInfo.this.sharedamagefighterid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             SkillShareDamageKillInfo.this.sharedamagefighterid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.sharedamagefighterid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSkillid(int _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "skillid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 327 */         new LogInt(this, SkillShareDamageKillInfo.this.skillid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             SkillShareDamageKillInfo.this.skillid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.skillid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFighterid(int _v_)
/*     */   {
/* 343 */     _xdb_verify_unsafe_();
/* 344 */     xdb.Logs.logIf(new LogKey(this, "fighterid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 348 */         new LogInt(this, SkillShareDamageKillInfo.this.fighterid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 352 */             SkillShareDamageKillInfo.this.fighterid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 356 */     });
/* 357 */     this.fighterid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 369 */         new xdb.logs.LogLong(this, SkillShareDamageKillInfo.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 373 */             SkillShareDamageKillInfo.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 377 */     });
/* 378 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 384 */     _xdb_verify_unsafe_();
/* 385 */     SkillShareDamageKillInfo _o_ = null;
/* 386 */     if ((_o1_ instanceof SkillShareDamageKillInfo)) { _o_ = (SkillShareDamageKillInfo)_o1_;
/* 387 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 388 */       return false;
/* 389 */     if (this.sharedamagetype != _o_.sharedamagetype) return false;
/* 390 */     if (this.sharedamagefighterid != _o_.sharedamagefighterid) return false;
/* 391 */     if (this.skillid != _o_.skillid) return false;
/* 392 */     if (this.fighterid != _o_.fighterid) return false;
/* 393 */     if (this.roleid != _o_.roleid) return false;
/* 394 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 400 */     _xdb_verify_unsafe_();
/* 401 */     int _h_ = 0;
/* 402 */     _h_ += this.sharedamagetype;
/* 403 */     _h_ += this.sharedamagefighterid;
/* 404 */     _h_ += this.skillid;
/* 405 */     _h_ += this.fighterid;
/* 406 */     _h_ = (int)(_h_ + this.roleid);
/* 407 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 413 */     _xdb_verify_unsafe_();
/* 414 */     StringBuilder _sb_ = new StringBuilder();
/* 415 */     _sb_.append("(");
/* 416 */     _sb_.append(this.sharedamagetype);
/* 417 */     _sb_.append(",");
/* 418 */     _sb_.append(this.sharedamagefighterid);
/* 419 */     _sb_.append(",");
/* 420 */     _sb_.append(this.skillid);
/* 421 */     _sb_.append(",");
/* 422 */     _sb_.append(this.fighterid);
/* 423 */     _sb_.append(",");
/* 424 */     _sb_.append(this.roleid);
/* 425 */     _sb_.append(")");
/* 426 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 432 */     ListenableBean lb = new ListenableBean();
/* 433 */     lb.add(new ListenableChanged().setVarName("sharedamagetype"));
/* 434 */     lb.add(new ListenableChanged().setVarName("sharedamagefighterid"));
/* 435 */     lb.add(new ListenableChanged().setVarName("skillid"));
/* 436 */     lb.add(new ListenableChanged().setVarName("fighterid"));
/* 437 */     lb.add(new ListenableChanged().setVarName("roleid"));
/* 438 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.SkillShareDamageKillInfo {
/*     */     private Const() {}
/*     */     
/*     */     SkillShareDamageKillInfo nThis() {
/* 445 */       return SkillShareDamageKillInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 451 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillShareDamageKillInfo copy()
/*     */     {
/* 457 */       return SkillShareDamageKillInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillShareDamageKillInfo toData()
/*     */     {
/* 463 */       return SkillShareDamageKillInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.SkillShareDamageKillInfo toBean()
/*     */     {
/* 468 */       return SkillShareDamageKillInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillShareDamageKillInfo toDataIf()
/*     */     {
/* 474 */       return SkillShareDamageKillInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.SkillShareDamageKillInfo toBeanIf()
/*     */     {
/* 479 */       return SkillShareDamageKillInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSharedamagetype()
/*     */     {
/* 486 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 487 */       return SkillShareDamageKillInfo.this.sharedamagetype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSharedamagefighterid()
/*     */     {
/* 494 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 495 */       return SkillShareDamageKillInfo.this.sharedamagefighterid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSkillid()
/*     */     {
/* 502 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 503 */       return SkillShareDamageKillInfo.this.skillid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFighterid()
/*     */     {
/* 510 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 511 */       return SkillShareDamageKillInfo.this.fighterid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 518 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 519 */       return SkillShareDamageKillInfo.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSharedamagetype(int _v_)
/*     */     {
/* 526 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 527 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSharedamagefighterid(int _v_)
/*     */     {
/* 534 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSkillid(int _v_)
/*     */     {
/* 542 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 543 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFighterid(int _v_)
/*     */     {
/* 550 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 551 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 558 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 565 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 566 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 572 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 573 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 579 */       return SkillShareDamageKillInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 585 */       return SkillShareDamageKillInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 591 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 598 */       return SkillShareDamageKillInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 604 */       return SkillShareDamageKillInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 610 */       SkillShareDamageKillInfo.this._xdb_verify_unsafe_();
/* 611 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 617 */       return SkillShareDamageKillInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 623 */       return SkillShareDamageKillInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 629 */       return SkillShareDamageKillInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 635 */       return SkillShareDamageKillInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 641 */       return SkillShareDamageKillInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 647 */       return SkillShareDamageKillInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 653 */       return SkillShareDamageKillInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.SkillShareDamageKillInfo
/*     */   {
/*     */     private int sharedamagetype;
/*     */     
/*     */     private int sharedamagefighterid;
/*     */     
/*     */     private int skillid;
/*     */     
/*     */     private int fighterid;
/*     */     
/*     */     private long roleid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 673 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.SkillShareDamageKillInfo _o1_)
/*     */     {
/* 682 */       if ((_o1_ instanceof SkillShareDamageKillInfo)) { assign((SkillShareDamageKillInfo)_o1_);
/* 683 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 684 */       } else if ((_o1_ instanceof SkillShareDamageKillInfo.Const)) assign(((SkillShareDamageKillInfo.Const)_o1_).nThis()); else {
/* 685 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(SkillShareDamageKillInfo _o_) {
/* 690 */       this.sharedamagetype = _o_.sharedamagetype;
/* 691 */       this.sharedamagefighterid = _o_.sharedamagefighterid;
/* 692 */       this.skillid = _o_.skillid;
/* 693 */       this.fighterid = _o_.fighterid;
/* 694 */       this.roleid = _o_.roleid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 699 */       this.sharedamagetype = _o_.sharedamagetype;
/* 700 */       this.sharedamagefighterid = _o_.sharedamagefighterid;
/* 701 */       this.skillid = _o_.skillid;
/* 702 */       this.fighterid = _o_.fighterid;
/* 703 */       this.roleid = _o_.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 709 */       _os_.marshal(this.sharedamagetype);
/* 710 */       _os_.marshal(this.sharedamagefighterid);
/* 711 */       _os_.marshal(this.skillid);
/* 712 */       _os_.marshal(this.fighterid);
/* 713 */       _os_.marshal(this.roleid);
/* 714 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 720 */       this.sharedamagetype = _os_.unmarshal_int();
/* 721 */       this.sharedamagefighterid = _os_.unmarshal_int();
/* 722 */       this.skillid = _os_.unmarshal_int();
/* 723 */       this.fighterid = _os_.unmarshal_int();
/* 724 */       this.roleid = _os_.unmarshal_long();
/* 725 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 731 */       int _size_ = 0;
/* 732 */       _size_ += CodedOutputStream.computeInt32Size(1, this.sharedamagetype);
/* 733 */       _size_ += CodedOutputStream.computeInt32Size(2, this.sharedamagefighterid);
/* 734 */       _size_ += CodedOutputStream.computeInt32Size(3, this.skillid);
/* 735 */       _size_ += CodedOutputStream.computeInt32Size(4, this.fighterid);
/* 736 */       _size_ += CodedOutputStream.computeInt64Size(5, this.roleid);
/* 737 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 745 */         _output_.writeInt32(1, this.sharedamagetype);
/* 746 */         _output_.writeInt32(2, this.sharedamagefighterid);
/* 747 */         _output_.writeInt32(3, this.skillid);
/* 748 */         _output_.writeInt32(4, this.fighterid);
/* 749 */         _output_.writeInt64(5, this.roleid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 753 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 755 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 763 */         boolean done = false;
/* 764 */         while (!done)
/*     */         {
/* 766 */           int tag = _input_.readTag();
/* 767 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 771 */             done = true;
/* 772 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 776 */             this.sharedamagetype = _input_.readInt32();
/* 777 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 781 */             this.sharedamagefighterid = _input_.readInt32();
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 786 */             this.skillid = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 791 */             this.fighterid = _input_.readInt32();
/* 792 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 796 */             this.roleid = _input_.readInt64();
/* 797 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 801 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 803 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 812 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 816 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 818 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillShareDamageKillInfo copy()
/*     */     {
/* 824 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillShareDamageKillInfo toData()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.SkillShareDamageKillInfo toBean()
/*     */     {
/* 835 */       return new SkillShareDamageKillInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.SkillShareDamageKillInfo toDataIf()
/*     */     {
/* 841 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.SkillShareDamageKillInfo toBeanIf()
/*     */     {
/* 846 */       return new SkillShareDamageKillInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 852 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 872 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 876 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSharedamagetype()
/*     */     {
/* 883 */       return this.sharedamagetype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSharedamagefighterid()
/*     */     {
/* 890 */       return this.sharedamagefighterid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSkillid()
/*     */     {
/* 897 */       return this.skillid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFighterid()
/*     */     {
/* 904 */       return this.fighterid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 911 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSharedamagetype(int _v_)
/*     */     {
/* 918 */       this.sharedamagetype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSharedamagefighterid(int _v_)
/*     */     {
/* 925 */       this.sharedamagefighterid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSkillid(int _v_)
/*     */     {
/* 932 */       this.skillid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFighterid(int _v_)
/*     */     {
/* 939 */       this.fighterid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 946 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 952 */       if (!(_o1_ instanceof Data)) return false;
/* 953 */       Data _o_ = (Data)_o1_;
/* 954 */       if (this.sharedamagetype != _o_.sharedamagetype) return false;
/* 955 */       if (this.sharedamagefighterid != _o_.sharedamagefighterid) return false;
/* 956 */       if (this.skillid != _o_.skillid) return false;
/* 957 */       if (this.fighterid != _o_.fighterid) return false;
/* 958 */       if (this.roleid != _o_.roleid) return false;
/* 959 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 965 */       int _h_ = 0;
/* 966 */       _h_ += this.sharedamagetype;
/* 967 */       _h_ += this.sharedamagefighterid;
/* 968 */       _h_ += this.skillid;
/* 969 */       _h_ += this.fighterid;
/* 970 */       _h_ = (int)(_h_ + this.roleid);
/* 971 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 977 */       StringBuilder _sb_ = new StringBuilder();
/* 978 */       _sb_.append("(");
/* 979 */       _sb_.append(this.sharedamagetype);
/* 980 */       _sb_.append(",");
/* 981 */       _sb_.append(this.sharedamagefighterid);
/* 982 */       _sb_.append(",");
/* 983 */       _sb_.append(this.skillid);
/* 984 */       _sb_.append(",");
/* 985 */       _sb_.append(this.fighterid);
/* 986 */       _sb_.append(",");
/* 987 */       _sb_.append(this.roleid);
/* 988 */       _sb_.append(")");
/* 989 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SkillShareDamageKillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */