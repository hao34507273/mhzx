/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class AwardTotalData extends XBean implements xbean.AwardTotalData
/*      */ {
/*      */   private long starttime;
/*      */   private long yuanbao;
/*      */   private long gold;
/*      */   private long silver;
/*      */   private long goldingot;
/*      */   private long roleexp;
/*      */   private long petexp;
/*      */   private int rolestartlv;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.starttime = 0L;
/*   33 */     this.yuanbao = 0L;
/*   34 */     this.gold = 0L;
/*   35 */     this.silver = 0L;
/*   36 */     this.goldingot = 0L;
/*   37 */     this.roleexp = 0L;
/*   38 */     this.petexp = 0L;
/*   39 */     this.rolestartlv = 0;
/*      */   }
/*      */   
/*      */   AwardTotalData(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public AwardTotalData()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public AwardTotalData(AwardTotalData _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   AwardTotalData(xbean.AwardTotalData _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof AwardTotalData)) { assign((AwardTotalData)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(AwardTotalData _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.starttime = _o_.starttime;
/*   70 */     this.yuanbao = _o_.yuanbao;
/*   71 */     this.gold = _o_.gold;
/*   72 */     this.silver = _o_.silver;
/*   73 */     this.goldingot = _o_.goldingot;
/*   74 */     this.roleexp = _o_.roleexp;
/*   75 */     this.petexp = _o_.petexp;
/*   76 */     this.rolestartlv = _o_.rolestartlv;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   81 */     this.starttime = _o_.starttime;
/*   82 */     this.yuanbao = _o_.yuanbao;
/*   83 */     this.gold = _o_.gold;
/*   84 */     this.silver = _o_.silver;
/*   85 */     this.goldingot = _o_.goldingot;
/*   86 */     this.roleexp = _o_.roleexp;
/*   87 */     this.petexp = _o_.petexp;
/*   88 */     this.rolestartlv = _o_.rolestartlv;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   94 */     _xdb_verify_unsafe_();
/*   95 */     _os_.marshal(this.starttime);
/*   96 */     _os_.marshal(this.yuanbao);
/*   97 */     _os_.marshal(this.gold);
/*   98 */     _os_.marshal(this.silver);
/*   99 */     _os_.marshal(this.goldingot);
/*  100 */     _os_.marshal(this.roleexp);
/*  101 */     _os_.marshal(this.petexp);
/*  102 */     _os_.marshal(this.rolestartlv);
/*  103 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  109 */     _xdb_verify_unsafe_();
/*  110 */     this.starttime = _os_.unmarshal_long();
/*  111 */     this.yuanbao = _os_.unmarshal_long();
/*  112 */     this.gold = _os_.unmarshal_long();
/*  113 */     this.silver = _os_.unmarshal_long();
/*  114 */     this.goldingot = _os_.unmarshal_long();
/*  115 */     this.roleexp = _os_.unmarshal_long();
/*  116 */     this.petexp = _os_.unmarshal_long();
/*  117 */     this.rolestartlv = _os_.unmarshal_int();
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     int _size_ = 0;
/*  126 */     _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/*  127 */     _size_ += CodedOutputStream.computeInt64Size(2, this.yuanbao);
/*  128 */     _size_ += CodedOutputStream.computeInt64Size(3, this.gold);
/*  129 */     _size_ += CodedOutputStream.computeInt64Size(4, this.silver);
/*  130 */     _size_ += CodedOutputStream.computeInt64Size(5, this.goldingot);
/*  131 */     _size_ += CodedOutputStream.computeInt64Size(6, this.roleexp);
/*  132 */     _size_ += CodedOutputStream.computeInt64Size(7, this.petexp);
/*  133 */     _size_ += CodedOutputStream.computeInt32Size(8, this.rolestartlv);
/*  134 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  143 */       _output_.writeInt64(1, this.starttime);
/*  144 */       _output_.writeInt64(2, this.yuanbao);
/*  145 */       _output_.writeInt64(3, this.gold);
/*  146 */       _output_.writeInt64(4, this.silver);
/*  147 */       _output_.writeInt64(5, this.goldingot);
/*  148 */       _output_.writeInt64(6, this.roleexp);
/*  149 */       _output_.writeInt64(7, this.petexp);
/*  150 */       _output_.writeInt32(8, this.rolestartlv);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  154 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  156 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  165 */       boolean done = false;
/*  166 */       while (!done)
/*      */       {
/*  168 */         int tag = _input_.readTag();
/*  169 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  173 */           done = true;
/*  174 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  178 */           this.starttime = _input_.readInt64();
/*  179 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  183 */           this.yuanbao = _input_.readInt64();
/*  184 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  188 */           this.gold = _input_.readInt64();
/*  189 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  193 */           this.silver = _input_.readInt64();
/*  194 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  198 */           this.goldingot = _input_.readInt64();
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  203 */           this.roleexp = _input_.readInt64();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  208 */           this.petexp = _input_.readInt64();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  213 */           this.rolestartlv = _input_.readInt32();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  218 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  220 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  229 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  233 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  235 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AwardTotalData copy()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new AwardTotalData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AwardTotalData toData()
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AwardTotalData toBean()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new AwardTotalData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.AwardTotalData toDataIf()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.AwardTotalData toBeanIf()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getYuanbao()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return this.yuanbao;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGold()
/*      */   {
/*  298 */     _xdb_verify_unsafe_();
/*  299 */     return this.gold;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSilver()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return this.silver;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGoldingot()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return this.goldingot;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleexp()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return this.roleexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getPetexp()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*  331 */     return this.petexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRolestartlv()
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     return this.rolestartlv;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  351 */         new LogLong(this, AwardTotalData.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  355 */             AwardTotalData.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  359 */     });
/*  360 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setYuanbao(long _v_)
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     Logs.logIf(new LogKey(this, "yuanbao")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  372 */         new LogLong(this, AwardTotalData.this.yuanbao)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  376 */             AwardTotalData.this.yuanbao = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  380 */     });
/*  381 */     this.yuanbao = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGold(long _v_)
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     Logs.logIf(new LogKey(this, "gold")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  393 */         new LogLong(this, AwardTotalData.this.gold)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  397 */             AwardTotalData.this.gold = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  401 */     });
/*  402 */     this.gold = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSilver(long _v_)
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     Logs.logIf(new LogKey(this, "silver")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  414 */         new LogLong(this, AwardTotalData.this.silver)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  418 */             AwardTotalData.this.silver = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  422 */     });
/*  423 */     this.silver = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGoldingot(long _v_)
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     Logs.logIf(new LogKey(this, "goldingot")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  435 */         new LogLong(this, AwardTotalData.this.goldingot)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  439 */             AwardTotalData.this.goldingot = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  443 */     });
/*  444 */     this.goldingot = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleexp(long _v_)
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     Logs.logIf(new LogKey(this, "roleexp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  456 */         new LogLong(this, AwardTotalData.this.roleexp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  460 */             AwardTotalData.this.roleexp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  464 */     });
/*  465 */     this.roleexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPetexp(long _v_)
/*      */   {
/*  472 */     _xdb_verify_unsafe_();
/*  473 */     Logs.logIf(new LogKey(this, "petexp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  477 */         new LogLong(this, AwardTotalData.this.petexp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  481 */             AwardTotalData.this.petexp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  485 */     });
/*  486 */     this.petexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRolestartlv(int _v_)
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     Logs.logIf(new LogKey(this, "rolestartlv")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  498 */         new LogInt(this, AwardTotalData.this.rolestartlv)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  502 */             AwardTotalData.this.rolestartlv = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  506 */     });
/*  507 */     this.rolestartlv = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  513 */     _xdb_verify_unsafe_();
/*  514 */     AwardTotalData _o_ = null;
/*  515 */     if ((_o1_ instanceof AwardTotalData)) { _o_ = (AwardTotalData)_o1_;
/*  516 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  517 */       return false;
/*  518 */     if (this.starttime != _o_.starttime) return false;
/*  519 */     if (this.yuanbao != _o_.yuanbao) return false;
/*  520 */     if (this.gold != _o_.gold) return false;
/*  521 */     if (this.silver != _o_.silver) return false;
/*  522 */     if (this.goldingot != _o_.goldingot) return false;
/*  523 */     if (this.roleexp != _o_.roleexp) return false;
/*  524 */     if (this.petexp != _o_.petexp) return false;
/*  525 */     if (this.rolestartlv != _o_.rolestartlv) return false;
/*  526 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  532 */     _xdb_verify_unsafe_();
/*  533 */     int _h_ = 0;
/*  534 */     _h_ = (int)(_h_ + this.starttime);
/*  535 */     _h_ = (int)(_h_ + this.yuanbao);
/*  536 */     _h_ = (int)(_h_ + this.gold);
/*  537 */     _h_ = (int)(_h_ + this.silver);
/*  538 */     _h_ = (int)(_h_ + this.goldingot);
/*  539 */     _h_ = (int)(_h_ + this.roleexp);
/*  540 */     _h_ = (int)(_h_ + this.petexp);
/*  541 */     _h_ += this.rolestartlv;
/*  542 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  548 */     _xdb_verify_unsafe_();
/*  549 */     StringBuilder _sb_ = new StringBuilder();
/*  550 */     _sb_.append("(");
/*  551 */     _sb_.append(this.starttime);
/*  552 */     _sb_.append(",");
/*  553 */     _sb_.append(this.yuanbao);
/*  554 */     _sb_.append(",");
/*  555 */     _sb_.append(this.gold);
/*  556 */     _sb_.append(",");
/*  557 */     _sb_.append(this.silver);
/*  558 */     _sb_.append(",");
/*  559 */     _sb_.append(this.goldingot);
/*  560 */     _sb_.append(",");
/*  561 */     _sb_.append(this.roleexp);
/*  562 */     _sb_.append(",");
/*  563 */     _sb_.append(this.petexp);
/*  564 */     _sb_.append(",");
/*  565 */     _sb_.append(this.rolestartlv);
/*  566 */     _sb_.append(")");
/*  567 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  573 */     ListenableBean lb = new ListenableBean();
/*  574 */     lb.add(new ListenableChanged().setVarName("starttime"));
/*  575 */     lb.add(new ListenableChanged().setVarName("yuanbao"));
/*  576 */     lb.add(new ListenableChanged().setVarName("gold"));
/*  577 */     lb.add(new ListenableChanged().setVarName("silver"));
/*  578 */     lb.add(new ListenableChanged().setVarName("goldingot"));
/*  579 */     lb.add(new ListenableChanged().setVarName("roleexp"));
/*  580 */     lb.add(new ListenableChanged().setVarName("petexp"));
/*  581 */     lb.add(new ListenableChanged().setVarName("rolestartlv"));
/*  582 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.AwardTotalData {
/*      */     private Const() {}
/*      */     
/*      */     AwardTotalData nThis() {
/*  589 */       return AwardTotalData.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  595 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AwardTotalData copy()
/*      */     {
/*  601 */       return AwardTotalData.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AwardTotalData toData()
/*      */     {
/*  607 */       return AwardTotalData.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.AwardTotalData toBean()
/*      */     {
/*  612 */       return AwardTotalData.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AwardTotalData toDataIf()
/*      */     {
/*  618 */       return AwardTotalData.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.AwardTotalData toBeanIf()
/*      */     {
/*  623 */       return AwardTotalData.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/*  630 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  631 */       return AwardTotalData.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getYuanbao()
/*      */     {
/*  638 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  639 */       return AwardTotalData.this.yuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGold()
/*      */     {
/*  646 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  647 */       return AwardTotalData.this.gold;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSilver()
/*      */     {
/*  654 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  655 */       return AwardTotalData.this.silver;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGoldingot()
/*      */     {
/*  662 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  663 */       return AwardTotalData.this.goldingot;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleexp()
/*      */     {
/*  670 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  671 */       return AwardTotalData.this.roleexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPetexp()
/*      */     {
/*  678 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  679 */       return AwardTotalData.this.petexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRolestartlv()
/*      */     {
/*  686 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  687 */       return AwardTotalData.this.rolestartlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/*  694 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  695 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYuanbao(long _v_)
/*      */     {
/*  702 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  703 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGold(long _v_)
/*      */     {
/*  710 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  711 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSilver(long _v_)
/*      */     {
/*  718 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  719 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoldingot(long _v_)
/*      */     {
/*  726 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  727 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleexp(long _v_)
/*      */     {
/*  734 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  735 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetexp(long _v_)
/*      */     {
/*  742 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  743 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRolestartlv(int _v_)
/*      */     {
/*  750 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  751 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  757 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  758 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  764 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  765 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  771 */       return AwardTotalData.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  777 */       return AwardTotalData.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  783 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  784 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  790 */       return AwardTotalData.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  796 */       return AwardTotalData.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  802 */       AwardTotalData.this._xdb_verify_unsafe_();
/*  803 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  809 */       return AwardTotalData.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  815 */       return AwardTotalData.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  821 */       return AwardTotalData.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  827 */       return AwardTotalData.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  833 */       return AwardTotalData.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  839 */       return AwardTotalData.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  845 */       return AwardTotalData.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.AwardTotalData
/*      */   {
/*      */     private long starttime;
/*      */     
/*      */     private long yuanbao;
/*      */     
/*      */     private long gold;
/*      */     
/*      */     private long silver;
/*      */     
/*      */     private long goldingot;
/*      */     
/*      */     private long roleexp;
/*      */     
/*      */     private long petexp;
/*      */     
/*      */     private int rolestartlv;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  871 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.AwardTotalData _o1_)
/*      */     {
/*  880 */       if ((_o1_ instanceof AwardTotalData)) { assign((AwardTotalData)_o1_);
/*  881 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  882 */       } else if ((_o1_ instanceof AwardTotalData.Const)) assign(((AwardTotalData.Const)_o1_).nThis()); else {
/*  883 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(AwardTotalData _o_) {
/*  888 */       this.starttime = _o_.starttime;
/*  889 */       this.yuanbao = _o_.yuanbao;
/*  890 */       this.gold = _o_.gold;
/*  891 */       this.silver = _o_.silver;
/*  892 */       this.goldingot = _o_.goldingot;
/*  893 */       this.roleexp = _o_.roleexp;
/*  894 */       this.petexp = _o_.petexp;
/*  895 */       this.rolestartlv = _o_.rolestartlv;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  900 */       this.starttime = _o_.starttime;
/*  901 */       this.yuanbao = _o_.yuanbao;
/*  902 */       this.gold = _o_.gold;
/*  903 */       this.silver = _o_.silver;
/*  904 */       this.goldingot = _o_.goldingot;
/*  905 */       this.roleexp = _o_.roleexp;
/*  906 */       this.petexp = _o_.petexp;
/*  907 */       this.rolestartlv = _o_.rolestartlv;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  913 */       _os_.marshal(this.starttime);
/*  914 */       _os_.marshal(this.yuanbao);
/*  915 */       _os_.marshal(this.gold);
/*  916 */       _os_.marshal(this.silver);
/*  917 */       _os_.marshal(this.goldingot);
/*  918 */       _os_.marshal(this.roleexp);
/*  919 */       _os_.marshal(this.petexp);
/*  920 */       _os_.marshal(this.rolestartlv);
/*  921 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  927 */       this.starttime = _os_.unmarshal_long();
/*  928 */       this.yuanbao = _os_.unmarshal_long();
/*  929 */       this.gold = _os_.unmarshal_long();
/*  930 */       this.silver = _os_.unmarshal_long();
/*  931 */       this.goldingot = _os_.unmarshal_long();
/*  932 */       this.roleexp = _os_.unmarshal_long();
/*  933 */       this.petexp = _os_.unmarshal_long();
/*  934 */       this.rolestartlv = _os_.unmarshal_int();
/*  935 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  941 */       int _size_ = 0;
/*  942 */       _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/*  943 */       _size_ += CodedOutputStream.computeInt64Size(2, this.yuanbao);
/*  944 */       _size_ += CodedOutputStream.computeInt64Size(3, this.gold);
/*  945 */       _size_ += CodedOutputStream.computeInt64Size(4, this.silver);
/*  946 */       _size_ += CodedOutputStream.computeInt64Size(5, this.goldingot);
/*  947 */       _size_ += CodedOutputStream.computeInt64Size(6, this.roleexp);
/*  948 */       _size_ += CodedOutputStream.computeInt64Size(7, this.petexp);
/*  949 */       _size_ += CodedOutputStream.computeInt32Size(8, this.rolestartlv);
/*  950 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  958 */         _output_.writeInt64(1, this.starttime);
/*  959 */         _output_.writeInt64(2, this.yuanbao);
/*  960 */         _output_.writeInt64(3, this.gold);
/*  961 */         _output_.writeInt64(4, this.silver);
/*  962 */         _output_.writeInt64(5, this.goldingot);
/*  963 */         _output_.writeInt64(6, this.roleexp);
/*  964 */         _output_.writeInt64(7, this.petexp);
/*  965 */         _output_.writeInt32(8, this.rolestartlv);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  969 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  971 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  979 */         boolean done = false;
/*  980 */         while (!done)
/*      */         {
/*  982 */           int tag = _input_.readTag();
/*  983 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  987 */             done = true;
/*  988 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  992 */             this.starttime = _input_.readInt64();
/*  993 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  997 */             this.yuanbao = _input_.readInt64();
/*  998 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1002 */             this.gold = _input_.readInt64();
/* 1003 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1007 */             this.silver = _input_.readInt64();
/* 1008 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1012 */             this.goldingot = _input_.readInt64();
/* 1013 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1017 */             this.roleexp = _input_.readInt64();
/* 1018 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1022 */             this.petexp = _input_.readInt64();
/* 1023 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1027 */             this.rolestartlv = _input_.readInt32();
/* 1028 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1032 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1034 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1043 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1047 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1049 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AwardTotalData copy()
/*      */     {
/* 1055 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AwardTotalData toData()
/*      */     {
/* 1061 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.AwardTotalData toBean()
/*      */     {
/* 1066 */       return new AwardTotalData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.AwardTotalData toDataIf()
/*      */     {
/* 1072 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.AwardTotalData toBeanIf()
/*      */     {
/* 1077 */       return new AwardTotalData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1083 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1087 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1091 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1095 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1099 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1103 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1107 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1114 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getYuanbao()
/*      */     {
/* 1121 */       return this.yuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGold()
/*      */     {
/* 1128 */       return this.gold;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSilver()
/*      */     {
/* 1135 */       return this.silver;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGoldingot()
/*      */     {
/* 1142 */       return this.goldingot;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleexp()
/*      */     {
/* 1149 */       return this.roleexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPetexp()
/*      */     {
/* 1156 */       return this.petexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRolestartlv()
/*      */     {
/* 1163 */       return this.rolestartlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1170 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYuanbao(long _v_)
/*      */     {
/* 1177 */       this.yuanbao = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGold(long _v_)
/*      */     {
/* 1184 */       this.gold = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSilver(long _v_)
/*      */     {
/* 1191 */       this.silver = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoldingot(long _v_)
/*      */     {
/* 1198 */       this.goldingot = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleexp(long _v_)
/*      */     {
/* 1205 */       this.roleexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPetexp(long _v_)
/*      */     {
/* 1212 */       this.petexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRolestartlv(int _v_)
/*      */     {
/* 1219 */       this.rolestartlv = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1225 */       if (!(_o1_ instanceof Data)) return false;
/* 1226 */       Data _o_ = (Data)_o1_;
/* 1227 */       if (this.starttime != _o_.starttime) return false;
/* 1228 */       if (this.yuanbao != _o_.yuanbao) return false;
/* 1229 */       if (this.gold != _o_.gold) return false;
/* 1230 */       if (this.silver != _o_.silver) return false;
/* 1231 */       if (this.goldingot != _o_.goldingot) return false;
/* 1232 */       if (this.roleexp != _o_.roleexp) return false;
/* 1233 */       if (this.petexp != _o_.petexp) return false;
/* 1234 */       if (this.rolestartlv != _o_.rolestartlv) return false;
/* 1235 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1241 */       int _h_ = 0;
/* 1242 */       _h_ = (int)(_h_ + this.starttime);
/* 1243 */       _h_ = (int)(_h_ + this.yuanbao);
/* 1244 */       _h_ = (int)(_h_ + this.gold);
/* 1245 */       _h_ = (int)(_h_ + this.silver);
/* 1246 */       _h_ = (int)(_h_ + this.goldingot);
/* 1247 */       _h_ = (int)(_h_ + this.roleexp);
/* 1248 */       _h_ = (int)(_h_ + this.petexp);
/* 1249 */       _h_ += this.rolestartlv;
/* 1250 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1256 */       StringBuilder _sb_ = new StringBuilder();
/* 1257 */       _sb_.append("(");
/* 1258 */       _sb_.append(this.starttime);
/* 1259 */       _sb_.append(",");
/* 1260 */       _sb_.append(this.yuanbao);
/* 1261 */       _sb_.append(",");
/* 1262 */       _sb_.append(this.gold);
/* 1263 */       _sb_.append(",");
/* 1264 */       _sb_.append(this.silver);
/* 1265 */       _sb_.append(",");
/* 1266 */       _sb_.append(this.goldingot);
/* 1267 */       _sb_.append(",");
/* 1268 */       _sb_.append(this.roleexp);
/* 1269 */       _sb_.append(",");
/* 1270 */       _sb_.append(this.petexp);
/* 1271 */       _sb_.append(",");
/* 1272 */       _sb_.append(this.rolestartlv);
/* 1273 */       _sb_.append(")");
/* 1274 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\AwardTotalData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */