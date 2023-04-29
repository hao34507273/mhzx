/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.Marshal;
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.Arrays;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class FightRecordInfo extends XBean implements xbean.FightRecordInfo
/*      */ {
/*      */   private int version;
/*      */   private byte[] enter_fight;
/*      */   private LinkedList<byte[]> rounds;
/*      */   private byte[] fight_end;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.version = 0;
/*   25 */     this.enter_fight = new byte[0];
/*   26 */     this.rounds.clear();
/*   27 */     this.fight_end = new byte[0];
/*      */   }
/*      */   
/*      */   FightRecordInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.enter_fight = new byte[0];
/*   34 */     this.rounds = new LinkedList();
/*   35 */     this.fight_end = new byte[0];
/*      */   }
/*      */   
/*      */   public FightRecordInfo()
/*      */   {
/*   40 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FightRecordInfo(FightRecordInfo _o_)
/*      */   {
/*   45 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FightRecordInfo(xbean.FightRecordInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     if ((_o1_ instanceof FightRecordInfo)) { assign((FightRecordInfo)_o1_);
/*   52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   54 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FightRecordInfo _o_) {
/*   59 */     _o_._xdb_verify_unsafe_();
/*   60 */     this.version = _o_.version;
/*   61 */     this.enter_fight = Arrays.copyOf(_o_.enter_fight, _o_.enter_fight.length);
/*   62 */     this.rounds = new LinkedList();
/*   63 */     for (byte[] _v_ : _o_.rounds)
/*   64 */       this.rounds.add(Arrays.copyOf(_v_, _v_.length));
/*   65 */     this.fight_end = Arrays.copyOf(_o_.fight_end, _o_.fight_end.length);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   70 */     this.version = _o_.version;
/*   71 */     this.enter_fight = Arrays.copyOf(_o_.enter_fight, _o_.enter_fight.length);
/*   72 */     this.rounds = new LinkedList();
/*   73 */     for (byte[] _v_ : _o_.rounds)
/*   74 */       this.rounds.add(Arrays.copyOf(_v_, _v_.length));
/*   75 */     this.fight_end = Arrays.copyOf(_o_.fight_end, _o_.fight_end.length);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   81 */     _xdb_verify_unsafe_();
/*   82 */     _os_.marshal(this.version);
/*   83 */     _os_.marshal(this.enter_fight);
/*   84 */     _os_.compact_uint32(this.rounds.size());
/*   85 */     for (byte[] _v_ : this.rounds)
/*      */     {
/*   87 */       _os_.marshal(_v_);
/*      */     }
/*   89 */     _os_.marshal(this.fight_end);
/*   90 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*   96 */     _xdb_verify_unsafe_();
/*   97 */     this.version = _os_.unmarshal_int();
/*   98 */     this.enter_fight = _os_.unmarshal_bytes();
/*   99 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  101 */       byte[] _v_ = new byte[0];
/*  102 */       _v_ = _os_.unmarshal_bytes();
/*  103 */       this.rounds.add(_v_);
/*      */     }
/*  105 */     this.fight_end = _os_.unmarshal_bytes();
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     int _size_ = 0;
/*  114 */     _size_ += CodedOutputStream.computeInt32Size(1, this.version);
/*  115 */     _size_ += CodedOutputStream.computeByteArraySize(2, this.enter_fight);
/*  116 */     for (byte[] _v_ : this.rounds)
/*      */     {
/*  118 */       _size_ += CodedOutputStream.computeByteArraySize(3, _v_);
/*      */     }
/*  120 */     _size_ += CodedOutputStream.computeByteArraySize(4, this.fight_end);
/*  121 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  127 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  130 */       _output_.writeInt32(1, this.version);
/*  131 */       _output_.writeByteArray(2, this.enter_fight);
/*  132 */       for (byte[] _v_ : this.rounds)
/*      */       {
/*  134 */         _output_.writeByteArray(3, _v_);
/*      */       }
/*  136 */       _output_.writeByteArray(4, this.fight_end);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  140 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  142 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  148 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  151 */       boolean done = false;
/*  152 */       while (!done)
/*      */       {
/*  154 */         int tag = _input_.readTag();
/*  155 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  159 */           done = true;
/*  160 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  164 */           this.version = _input_.readInt32();
/*  165 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  169 */           this.enter_fight = _input_.readByteArray();
/*  170 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  174 */           byte[] _v_ = new byte[0];
/*  175 */           _v_ = _input_.readByteArray();
/*  176 */           this.rounds.add(_v_);
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  181 */           this.fight_end = _input_.readByteArray();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  186 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  188 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  197 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  201 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  203 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FightRecordInfo copy()
/*      */   {
/*  209 */     _xdb_verify_unsafe_();
/*  210 */     return new FightRecordInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FightRecordInfo toData()
/*      */   {
/*  216 */     _xdb_verify_unsafe_();
/*  217 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FightRecordInfo toBean()
/*      */   {
/*  222 */     _xdb_verify_unsafe_();
/*  223 */     return new FightRecordInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FightRecordInfo toDataIf()
/*      */   {
/*  229 */     _xdb_verify_unsafe_();
/*  230 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FightRecordInfo toBeanIf()
/*      */   {
/*  235 */     _xdb_verify_unsafe_();
/*  236 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVersion()
/*      */   {
/*  250 */     _xdb_verify_unsafe_();
/*  251 */     return this.version;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public <T extends Marshal> T getEnter_fight(T _v_)
/*      */   {
/*  258 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  261 */       _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.enter_fight)));
/*  262 */       return _v_;
/*      */     }
/*      */     catch (MarshalException _e_)
/*      */     {
/*  266 */       throw new xio.MarshalError();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean isEnter_fightEmpty()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return this.enter_fight.length == 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public byte[] getEnter_fightCopy()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return Arrays.copyOf(this.enter_fight, this.enter_fight.length);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<byte[]> getRounds()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return xdb.Logs.logList(new LogKey(this, "rounds"), this.rounds);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<byte[]> getRoundsAsData()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*      */     
/*  299 */     FightRecordInfo _o_ = this;
/*  300 */     List<byte[]> rounds = new LinkedList();
/*  301 */     for (byte[] _v_ : _o_.rounds)
/*  302 */       rounds.add(Arrays.copyOf(_v_, _v_.length));
/*  303 */     return rounds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public <T extends Marshal> T getFight_end(T _v_)
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  313 */       _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.fight_end)));
/*  314 */       return _v_;
/*      */     }
/*      */     catch (MarshalException _e_)
/*      */     {
/*  318 */       throw new xio.MarshalError();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean isFight_endEmpty()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.fight_end.length == 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public byte[] getFight_endCopy()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return Arrays.copyOf(this.fight_end, this.fight_end.length);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVersion(int _v_)
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     xdb.Logs.logIf(new LogKey(this, "version")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  347 */         new xdb.logs.LogInt(this, FightRecordInfo.this.version)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  351 */             FightRecordInfo.this.version = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  355 */     });
/*  356 */     this.version = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEnter_fight(Marshal _v_)
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     xdb.Logs.logIf(new LogKey(this, "enter_fight")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  368 */         new xdb.logs.LogObject(this, FightRecordInfo.this.enter_fight)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  372 */             FightRecordInfo.this.enter_fight = ((byte[])this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  376 */     });
/*  377 */     this.enter_fight = _v_.marshal(new OctetsStream()).getBytes();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEnter_fightCopy(byte[] _v_)
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     xdb.Logs.logIf(new LogKey(this, "enter_fight")
/*      */     {
/*      */       protected xdb.Log create() {
/*  388 */         new xdb.logs.LogObject(this, FightRecordInfo.this.enter_fight)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  392 */             FightRecordInfo.this.enter_fight = ((byte[])this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  396 */     });
/*  397 */     this.enter_fight = Arrays.copyOf(_v_, _v_.length);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFight_end(Marshal _v_)
/*      */   {
/*  404 */     _xdb_verify_unsafe_();
/*  405 */     xdb.Logs.logIf(new LogKey(this, "fight_end")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  409 */         new xdb.logs.LogObject(this, FightRecordInfo.this.fight_end)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  413 */             FightRecordInfo.this.fight_end = ((byte[])this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  417 */     });
/*  418 */     this.fight_end = _v_.marshal(new OctetsStream()).getBytes();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFight_endCopy(byte[] _v_)
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     xdb.Logs.logIf(new LogKey(this, "fight_end")
/*      */     {
/*      */       protected xdb.Log create() {
/*  429 */         new xdb.logs.LogObject(this, FightRecordInfo.this.fight_end)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  433 */             FightRecordInfo.this.fight_end = ((byte[])this._xdb_saved);
/*      */           }
/*      */         };
/*      */       }
/*  437 */     });
/*  438 */     this.fight_end = Arrays.copyOf(_v_, _v_.length);
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     FightRecordInfo _o_ = null;
/*  446 */     if ((_o1_ instanceof FightRecordInfo)) { _o_ = (FightRecordInfo)_o1_;
/*  447 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  448 */       return false;
/*  449 */     if (this.version != _o_.version) return false;
/*  450 */     if (!Arrays.equals(this.enter_fight, _o_.enter_fight)) return false;
/*  451 */     if (!this.rounds.equals(_o_.rounds)) return false;
/*  452 */     if (!Arrays.equals(this.fight_end, _o_.fight_end)) return false;
/*  453 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     int _h_ = 0;
/*  461 */     _h_ += this.version;
/*  462 */     _h_ += Arrays.hashCode(this.enter_fight);
/*  463 */     _h_ += this.rounds.hashCode();
/*  464 */     _h_ += Arrays.hashCode(this.fight_end);
/*  465 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  471 */     _xdb_verify_unsafe_();
/*  472 */     StringBuilder _sb_ = new StringBuilder();
/*  473 */     _sb_.append("(");
/*  474 */     _sb_.append(this.version);
/*  475 */     _sb_.append(",");
/*  476 */     _sb_.append('B').append(this.enter_fight.length);
/*  477 */     _sb_.append(",");
/*  478 */     _sb_.append(this.rounds);
/*  479 */     _sb_.append(",");
/*  480 */     _sb_.append('B').append(this.fight_end.length);
/*  481 */     _sb_.append(")");
/*  482 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  488 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  489 */     lb.add(new xdb.logs.ListenableChanged().setVarName("version"));
/*  490 */     lb.add(new xdb.logs.ListenableChanged().setVarName("enter_fight"));
/*  491 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rounds"));
/*  492 */     lb.add(new xdb.logs.ListenableChanged().setVarName("fight_end"));
/*  493 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FightRecordInfo {
/*      */     private Const() {}
/*      */     
/*      */     FightRecordInfo nThis() {
/*  500 */       return FightRecordInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  506 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightRecordInfo copy()
/*      */     {
/*  512 */       return FightRecordInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightRecordInfo toData()
/*      */     {
/*  518 */       return FightRecordInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FightRecordInfo toBean()
/*      */     {
/*  523 */       return FightRecordInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightRecordInfo toDataIf()
/*      */     {
/*  529 */       return FightRecordInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FightRecordInfo toBeanIf()
/*      */     {
/*  534 */       return FightRecordInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVersion()
/*      */     {
/*  541 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  542 */       return FightRecordInfo.this.version;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public <T extends Marshal> T getEnter_fight(T _v_)
/*      */     {
/*  549 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  550 */       return FightRecordInfo.this.getEnter_fight(_v_);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean isEnter_fightEmpty()
/*      */     {
/*  557 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  558 */       return FightRecordInfo.this.isEnter_fightEmpty();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public byte[] getEnter_fightCopy()
/*      */     {
/*  565 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  566 */       return FightRecordInfo.this.getEnter_fightCopy();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<byte[]> getRounds()
/*      */     {
/*  573 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  574 */       return xdb.Consts.constList(FightRecordInfo.this.rounds);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<byte[]> getRoundsAsData()
/*      */     {
/*  580 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*      */       
/*  582 */       FightRecordInfo _o_ = FightRecordInfo.this;
/*  583 */       List<byte[]> rounds = new LinkedList();
/*  584 */       for (byte[] _v_ : _o_.rounds)
/*  585 */         rounds.add(Arrays.copyOf(_v_, _v_.length));
/*  586 */       return rounds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public <T extends Marshal> T getFight_end(T _v_)
/*      */     {
/*  593 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  594 */       return FightRecordInfo.this.getFight_end(_v_);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean isFight_endEmpty()
/*      */     {
/*  601 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  602 */       return FightRecordInfo.this.isFight_endEmpty();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public byte[] getFight_endCopy()
/*      */     {
/*  609 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  610 */       return FightRecordInfo.this.getFight_endCopy();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVersion(int _v_)
/*      */     {
/*  617 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  618 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnter_fight(Marshal _v_)
/*      */     {
/*  625 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  626 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnter_fightCopy(byte[] _v_)
/*      */     {
/*  633 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  634 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFight_end(Marshal _v_)
/*      */     {
/*  641 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  642 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFight_endCopy(byte[] _v_)
/*      */     {
/*  649 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  650 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  656 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  657 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  663 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  664 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  670 */       return FightRecordInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  676 */       return FightRecordInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  682 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  689 */       return FightRecordInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  695 */       return FightRecordInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  701 */       FightRecordInfo.this._xdb_verify_unsafe_();
/*  702 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  708 */       return FightRecordInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  714 */       return FightRecordInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  720 */       return FightRecordInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  726 */       return FightRecordInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  732 */       return FightRecordInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  738 */       return FightRecordInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  744 */       return FightRecordInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FightRecordInfo
/*      */   {
/*      */     private int version;
/*      */     
/*      */     private byte[] enter_fight;
/*      */     
/*      */     private LinkedList<byte[]> rounds;
/*      */     
/*      */     private byte[] fight_end;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  762 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  767 */       this.enter_fight = new byte[0];
/*  768 */       this.rounds = new LinkedList();
/*  769 */       this.fight_end = new byte[0];
/*      */     }
/*      */     
/*      */     Data(xbean.FightRecordInfo _o1_)
/*      */     {
/*  774 */       if ((_o1_ instanceof FightRecordInfo)) { assign((FightRecordInfo)_o1_);
/*  775 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  776 */       } else if ((_o1_ instanceof FightRecordInfo.Const)) assign(((FightRecordInfo.Const)_o1_).nThis()); else {
/*  777 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FightRecordInfo _o_) {
/*  782 */       this.version = _o_.version;
/*  783 */       this.enter_fight = Arrays.copyOf(_o_.enter_fight, _o_.enter_fight.length);
/*  784 */       this.rounds = new LinkedList();
/*  785 */       for (byte[] _v_ : _o_.rounds)
/*  786 */         this.rounds.add(Arrays.copyOf(_v_, _v_.length));
/*  787 */       this.fight_end = Arrays.copyOf(_o_.fight_end, _o_.fight_end.length);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  792 */       this.version = _o_.version;
/*  793 */       this.enter_fight = Arrays.copyOf(_o_.enter_fight, _o_.enter_fight.length);
/*  794 */       this.rounds = new LinkedList();
/*  795 */       for (byte[] _v_ : _o_.rounds)
/*  796 */         this.rounds.add(Arrays.copyOf(_v_, _v_.length));
/*  797 */       this.fight_end = Arrays.copyOf(_o_.fight_end, _o_.fight_end.length);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  803 */       _os_.marshal(this.version);
/*  804 */       _os_.marshal(this.enter_fight);
/*  805 */       _os_.compact_uint32(this.rounds.size());
/*  806 */       for (byte[] _v_ : this.rounds)
/*      */       {
/*  808 */         _os_.marshal(_v_);
/*      */       }
/*  810 */       _os_.marshal(this.fight_end);
/*  811 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  817 */       this.version = _os_.unmarshal_int();
/*  818 */       this.enter_fight = _os_.unmarshal_bytes();
/*  819 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  821 */         byte[] _v_ = new byte[0];
/*  822 */         _v_ = _os_.unmarshal_bytes();
/*  823 */         this.rounds.add(_v_);
/*      */       }
/*  825 */       this.fight_end = _os_.unmarshal_bytes();
/*  826 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  832 */       int _size_ = 0;
/*  833 */       _size_ += CodedOutputStream.computeInt32Size(1, this.version);
/*  834 */       _size_ += CodedOutputStream.computeByteArraySize(2, this.enter_fight);
/*  835 */       for (byte[] _v_ : this.rounds)
/*      */       {
/*  837 */         _size_ += CodedOutputStream.computeByteArraySize(3, _v_);
/*      */       }
/*  839 */       _size_ += CodedOutputStream.computeByteArraySize(4, this.fight_end);
/*  840 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  848 */         _output_.writeInt32(1, this.version);
/*  849 */         _output_.writeByteArray(2, this.enter_fight);
/*  850 */         for (byte[] _v_ : this.rounds)
/*      */         {
/*  852 */           _output_.writeByteArray(3, _v_);
/*      */         }
/*  854 */         _output_.writeByteArray(4, this.fight_end);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  858 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  860 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  868 */         boolean done = false;
/*  869 */         while (!done)
/*      */         {
/*  871 */           int tag = _input_.readTag();
/*  872 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  876 */             done = true;
/*  877 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  881 */             this.version = _input_.readInt32();
/*  882 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/*  886 */             this.enter_fight = _input_.readByteArray();
/*  887 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/*  891 */             byte[] _v_ = new byte[0];
/*  892 */             _v_ = _input_.readByteArray();
/*  893 */             this.rounds.add(_v_);
/*  894 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/*  898 */             this.fight_end = _input_.readByteArray();
/*  899 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  903 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  905 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  914 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  918 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  920 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightRecordInfo copy()
/*      */     {
/*  926 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightRecordInfo toData()
/*      */     {
/*  932 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FightRecordInfo toBean()
/*      */     {
/*  937 */       return new FightRecordInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FightRecordInfo toDataIf()
/*      */     {
/*  943 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FightRecordInfo toBeanIf()
/*      */     {
/*  948 */       return new FightRecordInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  954 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  958 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  962 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  966 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  970 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  974 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  978 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVersion()
/*      */     {
/*  985 */       return this.version;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public <T extends Marshal> T getEnter_fight(T _v_)
/*      */     {
/*      */       try
/*      */       {
/*  994 */         _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.enter_fight)));
/*  995 */         return _v_;
/*      */       }
/*      */       catch (MarshalException _e_)
/*      */       {
/*  999 */         throw new xio.MarshalError();
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean isEnter_fightEmpty()
/*      */     {
/* 1007 */       return this.enter_fight.length == 0;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public byte[] getEnter_fightCopy()
/*      */     {
/* 1014 */       return Arrays.copyOf(this.enter_fight, this.enter_fight.length);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<byte[]> getRounds()
/*      */     {
/* 1021 */       return this.rounds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<byte[]> getRoundsAsData()
/*      */     {
/* 1028 */       return this.rounds;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public <T extends Marshal> T getFight_end(T _v_)
/*      */     {
/*      */       try
/*      */       {
/* 1037 */         _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.fight_end)));
/* 1038 */         return _v_;
/*      */       }
/*      */       catch (MarshalException _e_)
/*      */       {
/* 1042 */         throw new xio.MarshalError();
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean isFight_endEmpty()
/*      */     {
/* 1050 */       return this.fight_end.length == 0;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public byte[] getFight_endCopy()
/*      */     {
/* 1057 */       return Arrays.copyOf(this.fight_end, this.fight_end.length);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVersion(int _v_)
/*      */     {
/* 1064 */       this.version = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnter_fight(Marshal _v_)
/*      */     {
/* 1071 */       this.enter_fight = _v_.marshal(new OctetsStream()).getBytes();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnter_fightCopy(byte[] _v_)
/*      */     {
/* 1078 */       this.enter_fight = Arrays.copyOf(_v_, _v_.length);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFight_end(Marshal _v_)
/*      */     {
/* 1085 */       this.fight_end = _v_.marshal(new OctetsStream()).getBytes();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFight_endCopy(byte[] _v_)
/*      */     {
/* 1092 */       this.fight_end = Arrays.copyOf(_v_, _v_.length);
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1098 */       if (!(_o1_ instanceof Data)) return false;
/* 1099 */       Data _o_ = (Data)_o1_;
/* 1100 */       if (this.version != _o_.version) return false;
/* 1101 */       if (!Arrays.equals(this.enter_fight, _o_.enter_fight)) return false;
/* 1102 */       if (!this.rounds.equals(_o_.rounds)) return false;
/* 1103 */       if (!Arrays.equals(this.fight_end, _o_.fight_end)) return false;
/* 1104 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1110 */       int _h_ = 0;
/* 1111 */       _h_ += this.version;
/* 1112 */       _h_ += Arrays.hashCode(this.enter_fight);
/* 1113 */       _h_ += this.rounds.hashCode();
/* 1114 */       _h_ += Arrays.hashCode(this.fight_end);
/* 1115 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1121 */       StringBuilder _sb_ = new StringBuilder();
/* 1122 */       _sb_.append("(");
/* 1123 */       _sb_.append(this.version);
/* 1124 */       _sb_.append(",");
/* 1125 */       _sb_.append('B').append(this.enter_fight.length);
/* 1126 */       _sb_.append(",");
/* 1127 */       _sb_.append(this.rounds);
/* 1128 */       _sb_.append(",");
/* 1129 */       _sb_.append('B').append(this.fight_end.length);
/* 1130 */       _sb_.append(")");
/* 1131 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FightRecordInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */