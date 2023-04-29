/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class PetArenaFightInfo extends XBean implements xbean.PetArenaFightInfo
/*      */ {
/*      */   private long petid;
/*      */   private int position;
/*      */   private int pet_cfgid;
/*      */   private int monster_cfgid;
/*      */   private int damage;
/*      */   private String name;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.petid = 0L;
/*   29 */     this.position = 0;
/*   30 */     this.pet_cfgid = 0;
/*   31 */     this.monster_cfgid = 0;
/*   32 */     this.damage = 0;
/*   33 */     this.name = "";
/*      */   }
/*      */   
/*      */   PetArenaFightInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.petid = 0L;
/*   40 */     this.position = 0;
/*   41 */     this.pet_cfgid = 0;
/*   42 */     this.monster_cfgid = 0;
/*   43 */     this.damage = 0;
/*   44 */     this.name = "";
/*      */   }
/*      */   
/*      */   public PetArenaFightInfo()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public PetArenaFightInfo(PetArenaFightInfo _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   PetArenaFightInfo(xbean.PetArenaFightInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof PetArenaFightInfo)) { assign((PetArenaFightInfo)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(PetArenaFightInfo _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.petid = _o_.petid;
/*   70 */     this.position = _o_.position;
/*   71 */     this.pet_cfgid = _o_.pet_cfgid;
/*   72 */     this.monster_cfgid = _o_.monster_cfgid;
/*   73 */     this.damage = _o_.damage;
/*   74 */     this.name = _o_.name;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.petid = _o_.petid;
/*   80 */     this.position = _o_.position;
/*   81 */     this.pet_cfgid = _o_.pet_cfgid;
/*   82 */     this.monster_cfgid = _o_.monster_cfgid;
/*   83 */     this.damage = _o_.damage;
/*   84 */     this.name = _o_.name;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.marshal(this.petid);
/*   92 */     _os_.marshal(this.position);
/*   93 */     _os_.marshal(this.pet_cfgid);
/*   94 */     _os_.marshal(this.monster_cfgid);
/*   95 */     _os_.marshal(this.damage);
/*   96 */     _os_.marshal(this.name, "UTF-16LE");
/*   97 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     this.petid = _os_.unmarshal_long();
/*  105 */     this.position = _os_.unmarshal_int();
/*  106 */     this.pet_cfgid = _os_.unmarshal_int();
/*  107 */     this.monster_cfgid = _os_.unmarshal_int();
/*  108 */     this.damage = _os_.unmarshal_int();
/*  109 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  110 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*  117 */     int _size_ = 0;
/*  118 */     _size_ += CodedOutputStream.computeInt64Size(1, this.petid);
/*  119 */     _size_ += CodedOutputStream.computeInt32Size(2, this.position);
/*  120 */     _size_ += CodedOutputStream.computeInt32Size(3, this.pet_cfgid);
/*  121 */     _size_ += CodedOutputStream.computeInt32Size(4, this.monster_cfgid);
/*  122 */     _size_ += CodedOutputStream.computeInt32Size(5, this.damage);
/*      */     try
/*      */     {
/*  125 */       _size_ += CodedOutputStream.computeBytesSize(6, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  129 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  131 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  137 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  140 */       _output_.writeInt64(1, this.petid);
/*  141 */       _output_.writeInt32(2, this.position);
/*  142 */       _output_.writeInt32(3, this.pet_cfgid);
/*  143 */       _output_.writeInt32(4, this.monster_cfgid);
/*  144 */       _output_.writeInt32(5, this.damage);
/*  145 */       _output_.writeBytes(6, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  151 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  157 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  160 */       boolean done = false;
/*  161 */       while (!done)
/*      */       {
/*  163 */         int tag = _input_.readTag();
/*  164 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  168 */           done = true;
/*  169 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  173 */           this.petid = _input_.readInt64();
/*  174 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  178 */           this.position = _input_.readInt32();
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  183 */           this.pet_cfgid = _input_.readInt32();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  188 */           this.monster_cfgid = _input_.readInt32();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  193 */           this.damage = _input_.readInt32();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  198 */           this.name = _input_.readBytes().toString("UTF-16LE");
/*  199 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  203 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  205 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  214 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  218 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  220 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PetArenaFightInfo copy()
/*      */   {
/*  226 */     _xdb_verify_unsafe_();
/*  227 */     return new PetArenaFightInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PetArenaFightInfo toData()
/*      */   {
/*  233 */     _xdb_verify_unsafe_();
/*  234 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PetArenaFightInfo toBean()
/*      */   {
/*  239 */     _xdb_verify_unsafe_();
/*  240 */     return new PetArenaFightInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PetArenaFightInfo toDataIf()
/*      */   {
/*  246 */     _xdb_verify_unsafe_();
/*  247 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PetArenaFightInfo toBeanIf()
/*      */   {
/*  252 */     _xdb_verify_unsafe_();
/*  253 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  259 */     _xdb_verify_unsafe_();
/*  260 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getPetid()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return this.petid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPosition()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return this.position;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPet_cfgid()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return this.pet_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMonster_cfgid()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return this.monster_cfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDamage()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return this.damage;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return this.name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNameOctets()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return Octets.wrap(getName(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPetid(long _v_)
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     xdb.Logs.logIf(new LogKey(this, "petid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  328 */         new xdb.logs.LogLong(this, PetArenaFightInfo.this.petid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  332 */             PetArenaFightInfo.this.petid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  336 */     });
/*  337 */     this.petid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPosition(int _v_)
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     xdb.Logs.logIf(new LogKey(this, "position")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  349 */         new LogInt(this, PetArenaFightInfo.this.position)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  353 */             PetArenaFightInfo.this.position = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  357 */     });
/*  358 */     this.position = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPet_cfgid(int _v_)
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     xdb.Logs.logIf(new LogKey(this, "pet_cfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  370 */         new LogInt(this, PetArenaFightInfo.this.pet_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  374 */             PetArenaFightInfo.this.pet_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  378 */     });
/*  379 */     this.pet_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMonster_cfgid(int _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     xdb.Logs.logIf(new LogKey(this, "monster_cfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  391 */         new LogInt(this, PetArenaFightInfo.this.monster_cfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  395 */             PetArenaFightInfo.this.monster_cfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  399 */     });
/*  400 */     this.monster_cfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDamage(int _v_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     xdb.Logs.logIf(new LogKey(this, "damage")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  412 */         new LogInt(this, PetArenaFightInfo.this.damage)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  416 */             PetArenaFightInfo.this.damage = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  420 */     });
/*  421 */     this.damage = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName(String _v_)
/*      */   {
/*  428 */     _xdb_verify_unsafe_();
/*  429 */     if (null == _v_)
/*  430 */       throw new NullPointerException();
/*  431 */     xdb.Logs.logIf(new LogKey(this, "name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  435 */         new xdb.logs.LogString(this, PetArenaFightInfo.this.name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  439 */             PetArenaFightInfo.this.name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  443 */     });
/*  444 */     this.name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNameOctets(Octets _v_)
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     setName(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*  459 */     PetArenaFightInfo _o_ = null;
/*  460 */     if ((_o1_ instanceof PetArenaFightInfo)) { _o_ = (PetArenaFightInfo)_o1_;
/*  461 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  462 */       return false;
/*  463 */     if (this.petid != _o_.petid) return false;
/*  464 */     if (this.position != _o_.position) return false;
/*  465 */     if (this.pet_cfgid != _o_.pet_cfgid) return false;
/*  466 */     if (this.monster_cfgid != _o_.monster_cfgid) return false;
/*  467 */     if (this.damage != _o_.damage) return false;
/*  468 */     if (!this.name.equals(_o_.name)) return false;
/*  469 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*  476 */     int _h_ = 0;
/*  477 */     _h_ = (int)(_h_ + this.petid);
/*  478 */     _h_ += this.position;
/*  479 */     _h_ += this.pet_cfgid;
/*  480 */     _h_ += this.monster_cfgid;
/*  481 */     _h_ += this.damage;
/*  482 */     _h_ += this.name.hashCode();
/*  483 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  489 */     _xdb_verify_unsafe_();
/*  490 */     StringBuilder _sb_ = new StringBuilder();
/*  491 */     _sb_.append("(");
/*  492 */     _sb_.append(this.petid);
/*  493 */     _sb_.append(",");
/*  494 */     _sb_.append(this.position);
/*  495 */     _sb_.append(",");
/*  496 */     _sb_.append(this.pet_cfgid);
/*  497 */     _sb_.append(",");
/*  498 */     _sb_.append(this.monster_cfgid);
/*  499 */     _sb_.append(",");
/*  500 */     _sb_.append(this.damage);
/*  501 */     _sb_.append(",");
/*  502 */     _sb_.append("'").append(this.name).append("'");
/*  503 */     _sb_.append(")");
/*  504 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  510 */     ListenableBean lb = new ListenableBean();
/*  511 */     lb.add(new ListenableChanged().setVarName("petid"));
/*  512 */     lb.add(new ListenableChanged().setVarName("position"));
/*  513 */     lb.add(new ListenableChanged().setVarName("pet_cfgid"));
/*  514 */     lb.add(new ListenableChanged().setVarName("monster_cfgid"));
/*  515 */     lb.add(new ListenableChanged().setVarName("damage"));
/*  516 */     lb.add(new ListenableChanged().setVarName("name"));
/*  517 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.PetArenaFightInfo {
/*      */     private Const() {}
/*      */     
/*      */     PetArenaFightInfo nThis() {
/*  524 */       return PetArenaFightInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  530 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightInfo copy()
/*      */     {
/*  536 */       return PetArenaFightInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightInfo toData()
/*      */     {
/*  542 */       return PetArenaFightInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.PetArenaFightInfo toBean()
/*      */     {
/*  547 */       return PetArenaFightInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightInfo toDataIf()
/*      */     {
/*  553 */       return PetArenaFightInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.PetArenaFightInfo toBeanIf()
/*      */     {
/*  558 */       return PetArenaFightInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPetid()
/*      */     {
/*  565 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  566 */       return PetArenaFightInfo.this.petid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPosition()
/*      */     {
/*  573 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  574 */       return PetArenaFightInfo.this.position;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPet_cfgid()
/*      */     {
/*  581 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  582 */       return PetArenaFightInfo.this.pet_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMonster_cfgid()
/*      */     {
/*  589 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  590 */       return PetArenaFightInfo.this.monster_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDamage()
/*      */     {
/*  597 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  598 */       return PetArenaFightInfo.this.damage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/*  605 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  606 */       return PetArenaFightInfo.this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/*  613 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  614 */       return PetArenaFightInfo.this.getNameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetid(long _v_)
/*      */     {
/*  621 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  622 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPosition(int _v_)
/*      */     {
/*  629 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  630 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPet_cfgid(int _v_)
/*      */     {
/*  637 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  638 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMonster_cfgid(int _v_)
/*      */     {
/*  645 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  646 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDamage(int _v_)
/*      */     {
/*  653 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  654 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/*  661 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  662 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/*  669 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  670 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  676 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  677 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  683 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  684 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  690 */       return PetArenaFightInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  696 */       return PetArenaFightInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  702 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  703 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  709 */       return PetArenaFightInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  715 */       return PetArenaFightInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  721 */       PetArenaFightInfo.this._xdb_verify_unsafe_();
/*  722 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  728 */       return PetArenaFightInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  734 */       return PetArenaFightInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  740 */       return PetArenaFightInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  746 */       return PetArenaFightInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  752 */       return PetArenaFightInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  758 */       return PetArenaFightInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  764 */       return PetArenaFightInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.PetArenaFightInfo
/*      */   {
/*      */     private long petid;
/*      */     
/*      */     private int position;
/*      */     
/*      */     private int pet_cfgid;
/*      */     
/*      */     private int monster_cfgid;
/*      */     
/*      */     private int damage;
/*      */     
/*      */     private String name;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  786 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  791 */       this.petid = 0L;
/*  792 */       this.position = 0;
/*  793 */       this.pet_cfgid = 0;
/*  794 */       this.monster_cfgid = 0;
/*  795 */       this.damage = 0;
/*  796 */       this.name = "";
/*      */     }
/*      */     
/*      */     Data(xbean.PetArenaFightInfo _o1_)
/*      */     {
/*  801 */       if ((_o1_ instanceof PetArenaFightInfo)) { assign((PetArenaFightInfo)_o1_);
/*  802 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  803 */       } else if ((_o1_ instanceof PetArenaFightInfo.Const)) assign(((PetArenaFightInfo.Const)_o1_).nThis()); else {
/*  804 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(PetArenaFightInfo _o_) {
/*  809 */       this.petid = _o_.petid;
/*  810 */       this.position = _o_.position;
/*  811 */       this.pet_cfgid = _o_.pet_cfgid;
/*  812 */       this.monster_cfgid = _o_.monster_cfgid;
/*  813 */       this.damage = _o_.damage;
/*  814 */       this.name = _o_.name;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  819 */       this.petid = _o_.petid;
/*  820 */       this.position = _o_.position;
/*  821 */       this.pet_cfgid = _o_.pet_cfgid;
/*  822 */       this.monster_cfgid = _o_.monster_cfgid;
/*  823 */       this.damage = _o_.damage;
/*  824 */       this.name = _o_.name;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  830 */       _os_.marshal(this.petid);
/*  831 */       _os_.marshal(this.position);
/*  832 */       _os_.marshal(this.pet_cfgid);
/*  833 */       _os_.marshal(this.monster_cfgid);
/*  834 */       _os_.marshal(this.damage);
/*  835 */       _os_.marshal(this.name, "UTF-16LE");
/*  836 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  842 */       this.petid = _os_.unmarshal_long();
/*  843 */       this.position = _os_.unmarshal_int();
/*  844 */       this.pet_cfgid = _os_.unmarshal_int();
/*  845 */       this.monster_cfgid = _os_.unmarshal_int();
/*  846 */       this.damage = _os_.unmarshal_int();
/*  847 */       this.name = _os_.unmarshal_String("UTF-16LE");
/*  848 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  854 */       int _size_ = 0;
/*  855 */       _size_ += CodedOutputStream.computeInt64Size(1, this.petid);
/*  856 */       _size_ += CodedOutputStream.computeInt32Size(2, this.position);
/*  857 */       _size_ += CodedOutputStream.computeInt32Size(3, this.pet_cfgid);
/*  858 */       _size_ += CodedOutputStream.computeInt32Size(4, this.monster_cfgid);
/*  859 */       _size_ += CodedOutputStream.computeInt32Size(5, this.damage);
/*      */       try
/*      */       {
/*  862 */         _size_ += CodedOutputStream.computeBytesSize(6, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  866 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  868 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  876 */         _output_.writeInt64(1, this.petid);
/*  877 */         _output_.writeInt32(2, this.position);
/*  878 */         _output_.writeInt32(3, this.pet_cfgid);
/*  879 */         _output_.writeInt32(4, this.monster_cfgid);
/*  880 */         _output_.writeInt32(5, this.damage);
/*  881 */         _output_.writeBytes(6, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  885 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  887 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  895 */         boolean done = false;
/*  896 */         while (!done)
/*      */         {
/*  898 */           int tag = _input_.readTag();
/*  899 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  903 */             done = true;
/*  904 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  908 */             this.petid = _input_.readInt64();
/*  909 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  913 */             this.position = _input_.readInt32();
/*  914 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  918 */             this.pet_cfgid = _input_.readInt32();
/*  919 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  923 */             this.monster_cfgid = _input_.readInt32();
/*  924 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  928 */             this.damage = _input_.readInt32();
/*  929 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/*  933 */             this.name = _input_.readBytes().toString("UTF-16LE");
/*  934 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  938 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  940 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  949 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  953 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  955 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightInfo copy()
/*      */     {
/*  961 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightInfo toData()
/*      */     {
/*  967 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.PetArenaFightInfo toBean()
/*      */     {
/*  972 */       return new PetArenaFightInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PetArenaFightInfo toDataIf()
/*      */     {
/*  978 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.PetArenaFightInfo toBeanIf()
/*      */     {
/*  983 */       return new PetArenaFightInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  989 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  993 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  997 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1001 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1005 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1009 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1013 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPetid()
/*      */     {
/* 1020 */       return this.petid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPosition()
/*      */     {
/* 1027 */       return this.position;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPet_cfgid()
/*      */     {
/* 1034 */       return this.pet_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMonster_cfgid()
/*      */     {
/* 1041 */       return this.monster_cfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDamage()
/*      */     {
/* 1048 */       return this.damage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 1055 */       return this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 1062 */       return Octets.wrap(getName(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetid(long _v_)
/*      */     {
/* 1069 */       this.petid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPosition(int _v_)
/*      */     {
/* 1076 */       this.position = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPet_cfgid(int _v_)
/*      */     {
/* 1083 */       this.pet_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMonster_cfgid(int _v_)
/*      */     {
/* 1090 */       this.monster_cfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDamage(int _v_)
/*      */     {
/* 1097 */       this.damage = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 1104 */       if (null == _v_)
/* 1105 */         throw new NullPointerException();
/* 1106 */       this.name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 1113 */       setName(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1119 */       if (!(_o1_ instanceof Data)) return false;
/* 1120 */       Data _o_ = (Data)_o1_;
/* 1121 */       if (this.petid != _o_.petid) return false;
/* 1122 */       if (this.position != _o_.position) return false;
/* 1123 */       if (this.pet_cfgid != _o_.pet_cfgid) return false;
/* 1124 */       if (this.monster_cfgid != _o_.monster_cfgid) return false;
/* 1125 */       if (this.damage != _o_.damage) return false;
/* 1126 */       if (!this.name.equals(_o_.name)) return false;
/* 1127 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1133 */       int _h_ = 0;
/* 1134 */       _h_ = (int)(_h_ + this.petid);
/* 1135 */       _h_ += this.position;
/* 1136 */       _h_ += this.pet_cfgid;
/* 1137 */       _h_ += this.monster_cfgid;
/* 1138 */       _h_ += this.damage;
/* 1139 */       _h_ += this.name.hashCode();
/* 1140 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1146 */       StringBuilder _sb_ = new StringBuilder();
/* 1147 */       _sb_.append("(");
/* 1148 */       _sb_.append(this.petid);
/* 1149 */       _sb_.append(",");
/* 1150 */       _sb_.append(this.position);
/* 1151 */       _sb_.append(",");
/* 1152 */       _sb_.append(this.pet_cfgid);
/* 1153 */       _sb_.append(",");
/* 1154 */       _sb_.append(this.monster_cfgid);
/* 1155 */       _sb_.append(",");
/* 1156 */       _sb_.append(this.damage);
/* 1157 */       _sb_.append(",");
/* 1158 */       _sb_.append("'").append(this.name).append("'");
/* 1159 */       _sb_.append(")");
/* 1160 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PetArenaFightInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */