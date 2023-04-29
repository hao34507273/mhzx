/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class RoleSingleBattle extends XBean implements xbean.RoleSingleBattle
/*      */ {
/*      */   private long battleid;
/*      */   private int battlecfgid;
/*      */   private int campid;
/*      */   private int number;
/*      */   private long jointime;
/*      */   private int point;
/*      */   private xbean.RoleSessions rolesessions;
/*      */   private int killaddpoint;
/*      */   private int pvpfightcount;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.battleid = 0L;
/*   35 */     this.battlecfgid = 0;
/*   36 */     this.campid = 0;
/*   37 */     this.number = 0;
/*   38 */     this.jointime = 0L;
/*   39 */     this.point = 0;
/*   40 */     this.rolesessions._reset_unsafe_();
/*   41 */     this.killaddpoint = 0;
/*   42 */     this.pvpfightcount = 0;
/*      */   }
/*      */   
/*      */   RoleSingleBattle(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.rolesessions = new RoleSessions(0, this, "rolesessions");
/*      */   }
/*      */   
/*      */   public RoleSingleBattle()
/*      */   {
/*   53 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleSingleBattle(RoleSingleBattle _o_)
/*      */   {
/*   58 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleSingleBattle(xbean.RoleSingleBattle _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   63 */     super(_xp_, _vn_);
/*   64 */     if ((_o1_ instanceof RoleSingleBattle)) { assign((RoleSingleBattle)_o1_);
/*   65 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   66 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   67 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleSingleBattle _o_) {
/*   72 */     _o_._xdb_verify_unsafe_();
/*   73 */     this.battleid = _o_.battleid;
/*   74 */     this.battlecfgid = _o_.battlecfgid;
/*   75 */     this.campid = _o_.campid;
/*   76 */     this.number = _o_.number;
/*   77 */     this.jointime = _o_.jointime;
/*   78 */     this.point = _o_.point;
/*   79 */     this.rolesessions = new RoleSessions(_o_.rolesessions, this, "rolesessions");
/*   80 */     this.killaddpoint = _o_.killaddpoint;
/*   81 */     this.pvpfightcount = _o_.pvpfightcount;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   86 */     this.battleid = _o_.battleid;
/*   87 */     this.battlecfgid = _o_.battlecfgid;
/*   88 */     this.campid = _o_.campid;
/*   89 */     this.number = _o_.number;
/*   90 */     this.jointime = _o_.jointime;
/*   91 */     this.point = _o_.point;
/*   92 */     this.rolesessions = new RoleSessions(_o_.rolesessions, this, "rolesessions");
/*   93 */     this.killaddpoint = _o_.killaddpoint;
/*   94 */     this.pvpfightcount = _o_.pvpfightcount;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  100 */     _xdb_verify_unsafe_();
/*  101 */     _os_.marshal(this.battleid);
/*  102 */     _os_.marshal(this.battlecfgid);
/*  103 */     _os_.marshal(this.campid);
/*  104 */     _os_.marshal(this.number);
/*  105 */     _os_.marshal(this.jointime);
/*  106 */     _os_.marshal(this.point);
/*  107 */     this.rolesessions.marshal(_os_);
/*  108 */     _os_.marshal(this.killaddpoint);
/*  109 */     _os_.marshal(this.pvpfightcount);
/*  110 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*  117 */     this.battleid = _os_.unmarshal_long();
/*  118 */     this.battlecfgid = _os_.unmarshal_int();
/*  119 */     this.campid = _os_.unmarshal_int();
/*  120 */     this.number = _os_.unmarshal_int();
/*  121 */     this.jointime = _os_.unmarshal_long();
/*  122 */     this.point = _os_.unmarshal_int();
/*  123 */     this.rolesessions.unmarshal(_os_);
/*  124 */     this.killaddpoint = _os_.unmarshal_int();
/*  125 */     this.pvpfightcount = _os_.unmarshal_int();
/*  126 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*  133 */     int _size_ = 0;
/*  134 */     _size_ += CodedOutputStream.computeInt64Size(1, this.battleid);
/*  135 */     _size_ += CodedOutputStream.computeInt32Size(2, this.battlecfgid);
/*  136 */     _size_ += CodedOutputStream.computeInt32Size(3, this.campid);
/*  137 */     _size_ += CodedOutputStream.computeInt32Size(4, this.number);
/*  138 */     _size_ += CodedOutputStream.computeInt64Size(5, this.jointime);
/*  139 */     _size_ += CodedOutputStream.computeInt32Size(6, this.point);
/*  140 */     _size_ += CodedOutputStream.computeMessageSize(7, this.rolesessions);
/*  141 */     _size_ += CodedOutputStream.computeInt32Size(8, this.killaddpoint);
/*  142 */     _size_ += CodedOutputStream.computeInt32Size(9, this.pvpfightcount);
/*  143 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  149 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  152 */       _output_.writeInt64(1, this.battleid);
/*  153 */       _output_.writeInt32(2, this.battlecfgid);
/*  154 */       _output_.writeInt32(3, this.campid);
/*  155 */       _output_.writeInt32(4, this.number);
/*  156 */       _output_.writeInt64(5, this.jointime);
/*  157 */       _output_.writeInt32(6, this.point);
/*  158 */       _output_.writeMessage(7, this.rolesessions);
/*  159 */       _output_.writeInt32(8, this.killaddpoint);
/*  160 */       _output_.writeInt32(9, this.pvpfightcount);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  166 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  172 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  175 */       boolean done = false;
/*  176 */       while (!done)
/*      */       {
/*  178 */         int tag = _input_.readTag();
/*  179 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  183 */           done = true;
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  188 */           this.battleid = _input_.readInt64();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  193 */           this.battlecfgid = _input_.readInt32();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  198 */           this.campid = _input_.readInt32();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  203 */           this.number = _input_.readInt32();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  208 */           this.jointime = _input_.readInt64();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  213 */           this.point = _input_.readInt32();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  218 */           _input_.readMessage(this.rolesessions);
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  223 */           this.killaddpoint = _input_.readInt32();
/*  224 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  228 */           this.pvpfightcount = _input_.readInt32();
/*  229 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  233 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  235 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  244 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  248 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  250 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleSingleBattle copy()
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*  257 */     return new RoleSingleBattle(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleSingleBattle toData()
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*  264 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleSingleBattle toBean()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return new RoleSingleBattle(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleSingleBattle toDataIf()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleSingleBattle toBeanIf()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBattleid()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return this.battleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBattlecfgid()
/*      */   {
/*  305 */     _xdb_verify_unsafe_();
/*  306 */     return this.battlecfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCampid()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return this.campid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNumber()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return this.number;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getJointime()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return this.jointime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPoint()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return this.point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.RoleSessions getRolesessions()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     return this.rolesessions;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getKilladdpoint()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return this.killaddpoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPvpfightcount()
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*  362 */     return this.pvpfightcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBattleid(long _v_)
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     Logs.logIf(new LogKey(this, "battleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  374 */         new LogLong(this, RoleSingleBattle.this.battleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  378 */             RoleSingleBattle.this.battleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  382 */     });
/*  383 */     this.battleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBattlecfgid(int _v_)
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     Logs.logIf(new LogKey(this, "battlecfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  395 */         new LogInt(this, RoleSingleBattle.this.battlecfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  399 */             RoleSingleBattle.this.battlecfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  403 */     });
/*  404 */     this.battlecfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCampid(int _v_)
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     Logs.logIf(new LogKey(this, "campid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  416 */         new LogInt(this, RoleSingleBattle.this.campid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  420 */             RoleSingleBattle.this.campid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  424 */     });
/*  425 */     this.campid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNumber(int _v_)
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     Logs.logIf(new LogKey(this, "number")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  437 */         new LogInt(this, RoleSingleBattle.this.number)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  441 */             RoleSingleBattle.this.number = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  445 */     });
/*  446 */     this.number = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setJointime(long _v_)
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     Logs.logIf(new LogKey(this, "jointime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  458 */         new LogLong(this, RoleSingleBattle.this.jointime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  462 */             RoleSingleBattle.this.jointime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  466 */     });
/*  467 */     this.jointime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPoint(int _v_)
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*  475 */     Logs.logIf(new LogKey(this, "point")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  479 */         new LogInt(this, RoleSingleBattle.this.point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  483 */             RoleSingleBattle.this.point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  487 */     });
/*  488 */     this.point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setKilladdpoint(int _v_)
/*      */   {
/*  495 */     _xdb_verify_unsafe_();
/*  496 */     Logs.logIf(new LogKey(this, "killaddpoint")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  500 */         new LogInt(this, RoleSingleBattle.this.killaddpoint)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  504 */             RoleSingleBattle.this.killaddpoint = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  508 */     });
/*  509 */     this.killaddpoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPvpfightcount(int _v_)
/*      */   {
/*  516 */     _xdb_verify_unsafe_();
/*  517 */     Logs.logIf(new LogKey(this, "pvpfightcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  521 */         new LogInt(this, RoleSingleBattle.this.pvpfightcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  525 */             RoleSingleBattle.this.pvpfightcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  529 */     });
/*  530 */     this.pvpfightcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  536 */     _xdb_verify_unsafe_();
/*  537 */     RoleSingleBattle _o_ = null;
/*  538 */     if ((_o1_ instanceof RoleSingleBattle)) { _o_ = (RoleSingleBattle)_o1_;
/*  539 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  540 */       return false;
/*  541 */     if (this.battleid != _o_.battleid) return false;
/*  542 */     if (this.battlecfgid != _o_.battlecfgid) return false;
/*  543 */     if (this.campid != _o_.campid) return false;
/*  544 */     if (this.number != _o_.number) return false;
/*  545 */     if (this.jointime != _o_.jointime) return false;
/*  546 */     if (this.point != _o_.point) return false;
/*  547 */     if (!this.rolesessions.equals(_o_.rolesessions)) return false;
/*  548 */     if (this.killaddpoint != _o_.killaddpoint) return false;
/*  549 */     if (this.pvpfightcount != _o_.pvpfightcount) return false;
/*  550 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  556 */     _xdb_verify_unsafe_();
/*  557 */     int _h_ = 0;
/*  558 */     _h_ = (int)(_h_ + this.battleid);
/*  559 */     _h_ += this.battlecfgid;
/*  560 */     _h_ += this.campid;
/*  561 */     _h_ += this.number;
/*  562 */     _h_ = (int)(_h_ + this.jointime);
/*  563 */     _h_ += this.point;
/*  564 */     _h_ += this.rolesessions.hashCode();
/*  565 */     _h_ += this.killaddpoint;
/*  566 */     _h_ += this.pvpfightcount;
/*  567 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  573 */     _xdb_verify_unsafe_();
/*  574 */     StringBuilder _sb_ = new StringBuilder();
/*  575 */     _sb_.append("(");
/*  576 */     _sb_.append(this.battleid);
/*  577 */     _sb_.append(",");
/*  578 */     _sb_.append(this.battlecfgid);
/*  579 */     _sb_.append(",");
/*  580 */     _sb_.append(this.campid);
/*  581 */     _sb_.append(",");
/*  582 */     _sb_.append(this.number);
/*  583 */     _sb_.append(",");
/*  584 */     _sb_.append(this.jointime);
/*  585 */     _sb_.append(",");
/*  586 */     _sb_.append(this.point);
/*  587 */     _sb_.append(",");
/*  588 */     _sb_.append(this.rolesessions);
/*  589 */     _sb_.append(",");
/*  590 */     _sb_.append(this.killaddpoint);
/*  591 */     _sb_.append(",");
/*  592 */     _sb_.append(this.pvpfightcount);
/*  593 */     _sb_.append(")");
/*  594 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  600 */     ListenableBean lb = new ListenableBean();
/*  601 */     lb.add(new ListenableChanged().setVarName("battleid"));
/*  602 */     lb.add(new ListenableChanged().setVarName("battlecfgid"));
/*  603 */     lb.add(new ListenableChanged().setVarName("campid"));
/*  604 */     lb.add(new ListenableChanged().setVarName("number"));
/*  605 */     lb.add(new ListenableChanged().setVarName("jointime"));
/*  606 */     lb.add(new ListenableChanged().setVarName("point"));
/*  607 */     lb.add(new ListenableChanged().setVarName("rolesessions"));
/*  608 */     lb.add(new ListenableChanged().setVarName("killaddpoint"));
/*  609 */     lb.add(new ListenableChanged().setVarName("pvpfightcount"));
/*  610 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleSingleBattle {
/*      */     private Const() {}
/*      */     
/*      */     RoleSingleBattle nThis() {
/*  617 */       return RoleSingleBattle.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleBattle copy()
/*      */     {
/*  629 */       return RoleSingleBattle.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleBattle toData()
/*      */     {
/*  635 */       return RoleSingleBattle.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleSingleBattle toBean()
/*      */     {
/*  640 */       return RoleSingleBattle.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleBattle toDataIf()
/*      */     {
/*  646 */       return RoleSingleBattle.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleSingleBattle toBeanIf()
/*      */     {
/*  651 */       return RoleSingleBattle.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBattleid()
/*      */     {
/*  658 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  659 */       return RoleSingleBattle.this.battleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBattlecfgid()
/*      */     {
/*  666 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  667 */       return RoleSingleBattle.this.battlecfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCampid()
/*      */     {
/*  674 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  675 */       return RoleSingleBattle.this.campid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNumber()
/*      */     {
/*  682 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  683 */       return RoleSingleBattle.this.number;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getJointime()
/*      */     {
/*  690 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  691 */       return RoleSingleBattle.this.jointime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPoint()
/*      */     {
/*  698 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  699 */       return RoleSingleBattle.this.point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.RoleSessions getRolesessions()
/*      */     {
/*  706 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  707 */       return (xbean.RoleSessions)Consts.toConst(RoleSingleBattle.this.rolesessions);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getKilladdpoint()
/*      */     {
/*  714 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  715 */       return RoleSingleBattle.this.killaddpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPvpfightcount()
/*      */     {
/*  722 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  723 */       return RoleSingleBattle.this.pvpfightcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBattleid(long _v_)
/*      */     {
/*  730 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  731 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBattlecfgid(int _v_)
/*      */     {
/*  738 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCampid(int _v_)
/*      */     {
/*  746 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  747 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNumber(int _v_)
/*      */     {
/*  754 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  755 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJointime(long _v_)
/*      */     {
/*  762 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  763 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPoint(int _v_)
/*      */     {
/*  770 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  771 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKilladdpoint(int _v_)
/*      */     {
/*  778 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  779 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPvpfightcount(int _v_)
/*      */     {
/*  786 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  787 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  793 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  794 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  800 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  801 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  807 */       return RoleSingleBattle.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  813 */       return RoleSingleBattle.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  819 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  820 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  826 */       return RoleSingleBattle.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  832 */       return RoleSingleBattle.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  838 */       RoleSingleBattle.this._xdb_verify_unsafe_();
/*  839 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  845 */       return RoleSingleBattle.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  851 */       return RoleSingleBattle.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  857 */       return RoleSingleBattle.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  863 */       return RoleSingleBattle.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  869 */       return RoleSingleBattle.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  875 */       return RoleSingleBattle.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  881 */       return RoleSingleBattle.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleSingleBattle
/*      */   {
/*      */     private long battleid;
/*      */     
/*      */     private int battlecfgid;
/*      */     
/*      */     private int campid;
/*      */     
/*      */     private int number;
/*      */     
/*      */     private long jointime;
/*      */     
/*      */     private int point;
/*      */     
/*      */     private xbean.RoleSessions rolesessions;
/*      */     
/*      */     private int killaddpoint;
/*      */     
/*      */     private int pvpfightcount;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  909 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  914 */       this.rolesessions = new RoleSessions.Data();
/*      */     }
/*      */     
/*      */     Data(xbean.RoleSingleBattle _o1_)
/*      */     {
/*  919 */       if ((_o1_ instanceof RoleSingleBattle)) { assign((RoleSingleBattle)_o1_);
/*  920 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  921 */       } else if ((_o1_ instanceof RoleSingleBattle.Const)) assign(((RoleSingleBattle.Const)_o1_).nThis()); else {
/*  922 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleSingleBattle _o_) {
/*  927 */       this.battleid = _o_.battleid;
/*  928 */       this.battlecfgid = _o_.battlecfgid;
/*  929 */       this.campid = _o_.campid;
/*  930 */       this.number = _o_.number;
/*  931 */       this.jointime = _o_.jointime;
/*  932 */       this.point = _o_.point;
/*  933 */       this.rolesessions = new RoleSessions.Data(_o_.rolesessions);
/*  934 */       this.killaddpoint = _o_.killaddpoint;
/*  935 */       this.pvpfightcount = _o_.pvpfightcount;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  940 */       this.battleid = _o_.battleid;
/*  941 */       this.battlecfgid = _o_.battlecfgid;
/*  942 */       this.campid = _o_.campid;
/*  943 */       this.number = _o_.number;
/*  944 */       this.jointime = _o_.jointime;
/*  945 */       this.point = _o_.point;
/*  946 */       this.rolesessions = new RoleSessions.Data(_o_.rolesessions);
/*  947 */       this.killaddpoint = _o_.killaddpoint;
/*  948 */       this.pvpfightcount = _o_.pvpfightcount;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  954 */       _os_.marshal(this.battleid);
/*  955 */       _os_.marshal(this.battlecfgid);
/*  956 */       _os_.marshal(this.campid);
/*  957 */       _os_.marshal(this.number);
/*  958 */       _os_.marshal(this.jointime);
/*  959 */       _os_.marshal(this.point);
/*  960 */       this.rolesessions.marshal(_os_);
/*  961 */       _os_.marshal(this.killaddpoint);
/*  962 */       _os_.marshal(this.pvpfightcount);
/*  963 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  969 */       this.battleid = _os_.unmarshal_long();
/*  970 */       this.battlecfgid = _os_.unmarshal_int();
/*  971 */       this.campid = _os_.unmarshal_int();
/*  972 */       this.number = _os_.unmarshal_int();
/*  973 */       this.jointime = _os_.unmarshal_long();
/*  974 */       this.point = _os_.unmarshal_int();
/*  975 */       this.rolesessions.unmarshal(_os_);
/*  976 */       this.killaddpoint = _os_.unmarshal_int();
/*  977 */       this.pvpfightcount = _os_.unmarshal_int();
/*  978 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  984 */       int _size_ = 0;
/*  985 */       _size_ += CodedOutputStream.computeInt64Size(1, this.battleid);
/*  986 */       _size_ += CodedOutputStream.computeInt32Size(2, this.battlecfgid);
/*  987 */       _size_ += CodedOutputStream.computeInt32Size(3, this.campid);
/*  988 */       _size_ += CodedOutputStream.computeInt32Size(4, this.number);
/*  989 */       _size_ += CodedOutputStream.computeInt64Size(5, this.jointime);
/*  990 */       _size_ += CodedOutputStream.computeInt32Size(6, this.point);
/*  991 */       _size_ += CodedOutputStream.computeMessageSize(7, this.rolesessions);
/*  992 */       _size_ += CodedOutputStream.computeInt32Size(8, this.killaddpoint);
/*  993 */       _size_ += CodedOutputStream.computeInt32Size(9, this.pvpfightcount);
/*  994 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1002 */         _output_.writeInt64(1, this.battleid);
/* 1003 */         _output_.writeInt32(2, this.battlecfgid);
/* 1004 */         _output_.writeInt32(3, this.campid);
/* 1005 */         _output_.writeInt32(4, this.number);
/* 1006 */         _output_.writeInt64(5, this.jointime);
/* 1007 */         _output_.writeInt32(6, this.point);
/* 1008 */         _output_.writeMessage(7, this.rolesessions);
/* 1009 */         _output_.writeInt32(8, this.killaddpoint);
/* 1010 */         _output_.writeInt32(9, this.pvpfightcount);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1014 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1016 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1024 */         boolean done = false;
/* 1025 */         while (!done)
/*      */         {
/* 1027 */           int tag = _input_.readTag();
/* 1028 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1032 */             done = true;
/* 1033 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1037 */             this.battleid = _input_.readInt64();
/* 1038 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1042 */             this.battlecfgid = _input_.readInt32();
/* 1043 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1047 */             this.campid = _input_.readInt32();
/* 1048 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1052 */             this.number = _input_.readInt32();
/* 1053 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1057 */             this.jointime = _input_.readInt64();
/* 1058 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1062 */             this.point = _input_.readInt32();
/* 1063 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1067 */             _input_.readMessage(this.rolesessions);
/* 1068 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1072 */             this.killaddpoint = _input_.readInt32();
/* 1073 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1077 */             this.pvpfightcount = _input_.readInt32();
/* 1078 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1082 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1084 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1093 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1097 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1099 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleBattle copy()
/*      */     {
/* 1105 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleBattle toData()
/*      */     {
/* 1111 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleSingleBattle toBean()
/*      */     {
/* 1116 */       return new RoleSingleBattle(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleSingleBattle toDataIf()
/*      */     {
/* 1122 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleSingleBattle toBeanIf()
/*      */     {
/* 1127 */       return new RoleSingleBattle(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1133 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1137 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1141 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1145 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1149 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1153 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1157 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBattleid()
/*      */     {
/* 1164 */       return this.battleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBattlecfgid()
/*      */     {
/* 1171 */       return this.battlecfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCampid()
/*      */     {
/* 1178 */       return this.campid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNumber()
/*      */     {
/* 1185 */       return this.number;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getJointime()
/*      */     {
/* 1192 */       return this.jointime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPoint()
/*      */     {
/* 1199 */       return this.point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.RoleSessions getRolesessions()
/*      */     {
/* 1206 */       return this.rolesessions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getKilladdpoint()
/*      */     {
/* 1213 */       return this.killaddpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPvpfightcount()
/*      */     {
/* 1220 */       return this.pvpfightcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBattleid(long _v_)
/*      */     {
/* 1227 */       this.battleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBattlecfgid(int _v_)
/*      */     {
/* 1234 */       this.battlecfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCampid(int _v_)
/*      */     {
/* 1241 */       this.campid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNumber(int _v_)
/*      */     {
/* 1248 */       this.number = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJointime(long _v_)
/*      */     {
/* 1255 */       this.jointime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPoint(int _v_)
/*      */     {
/* 1262 */       this.point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKilladdpoint(int _v_)
/*      */     {
/* 1269 */       this.killaddpoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPvpfightcount(int _v_)
/*      */     {
/* 1276 */       this.pvpfightcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1282 */       if (!(_o1_ instanceof Data)) return false;
/* 1283 */       Data _o_ = (Data)_o1_;
/* 1284 */       if (this.battleid != _o_.battleid) return false;
/* 1285 */       if (this.battlecfgid != _o_.battlecfgid) return false;
/* 1286 */       if (this.campid != _o_.campid) return false;
/* 1287 */       if (this.number != _o_.number) return false;
/* 1288 */       if (this.jointime != _o_.jointime) return false;
/* 1289 */       if (this.point != _o_.point) return false;
/* 1290 */       if (!this.rolesessions.equals(_o_.rolesessions)) return false;
/* 1291 */       if (this.killaddpoint != _o_.killaddpoint) return false;
/* 1292 */       if (this.pvpfightcount != _o_.pvpfightcount) return false;
/* 1293 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1299 */       int _h_ = 0;
/* 1300 */       _h_ = (int)(_h_ + this.battleid);
/* 1301 */       _h_ += this.battlecfgid;
/* 1302 */       _h_ += this.campid;
/* 1303 */       _h_ += this.number;
/* 1304 */       _h_ = (int)(_h_ + this.jointime);
/* 1305 */       _h_ += this.point;
/* 1306 */       _h_ += this.rolesessions.hashCode();
/* 1307 */       _h_ += this.killaddpoint;
/* 1308 */       _h_ += this.pvpfightcount;
/* 1309 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1315 */       StringBuilder _sb_ = new StringBuilder();
/* 1316 */       _sb_.append("(");
/* 1317 */       _sb_.append(this.battleid);
/* 1318 */       _sb_.append(",");
/* 1319 */       _sb_.append(this.battlecfgid);
/* 1320 */       _sb_.append(",");
/* 1321 */       _sb_.append(this.campid);
/* 1322 */       _sb_.append(",");
/* 1323 */       _sb_.append(this.number);
/* 1324 */       _sb_.append(",");
/* 1325 */       _sb_.append(this.jointime);
/* 1326 */       _sb_.append(",");
/* 1327 */       _sb_.append(this.point);
/* 1328 */       _sb_.append(",");
/* 1329 */       _sb_.append(this.rolesessions);
/* 1330 */       _sb_.append(",");
/* 1331 */       _sb_.append(this.killaddpoint);
/* 1332 */       _sb_.append(",");
/* 1333 */       _sb_.append(this.pvpfightcount);
/* 1334 */       _sb_.append(")");
/* 1335 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleSingleBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */