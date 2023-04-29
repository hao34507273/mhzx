/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class Property extends XBean implements xbean.Property
/*      */ {
/*      */   private int partnercfgid;
/*      */   private int hp;
/*      */   private int mp;
/*      */   private ArrayList<Integer> skills;
/*      */   private ArrayList<Integer> loves;
/*      */   private ArrayList<Integer> lovestoreplace;
/*      */   private int fightvalue;
/*      */   private HashMap<Integer, Integer> ownskills;
/*      */   private int yuanlv;
/*      */   private ArrayList<Integer> subyuanlv;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   36 */     this.partnercfgid = 0;
/*   37 */     this.hp = 0;
/*   38 */     this.mp = 0;
/*   39 */     this.skills.clear();
/*   40 */     this.loves.clear();
/*   41 */     this.lovestoreplace.clear();
/*   42 */     this.fightvalue = 0;
/*   43 */     this.ownskills.clear();
/*   44 */     this.yuanlv = 0;
/*   45 */     this.subyuanlv.clear();
/*      */   }
/*      */   
/*      */   Property(int __, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     this.skills = new ArrayList();
/*   52 */     this.loves = new ArrayList();
/*   53 */     this.lovestoreplace = new ArrayList();
/*   54 */     this.ownskills = new HashMap();
/*   55 */     this.subyuanlv = new ArrayList();
/*      */   }
/*      */   
/*      */   public Property()
/*      */   {
/*   60 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Property(Property _o_)
/*      */   {
/*   65 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Property(xbean.Property _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   70 */     super(_xp_, _vn_);
/*   71 */     if ((_o1_ instanceof Property)) { assign((Property)_o1_);
/*   72 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   73 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   74 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Property _o_) {
/*   79 */     _o_._xdb_verify_unsafe_();
/*   80 */     this.partnercfgid = _o_.partnercfgid;
/*   81 */     this.hp = _o_.hp;
/*   82 */     this.mp = _o_.mp;
/*   83 */     this.skills = new ArrayList();
/*   84 */     this.skills.addAll(_o_.skills);
/*   85 */     this.loves = new ArrayList();
/*   86 */     this.loves.addAll(_o_.loves);
/*   87 */     this.lovestoreplace = new ArrayList();
/*   88 */     this.lovestoreplace.addAll(_o_.lovestoreplace);
/*   89 */     this.fightvalue = _o_.fightvalue;
/*   90 */     this.ownskills = new HashMap();
/*   91 */     for (Map.Entry<Integer, Integer> _e_ : _o_.ownskills.entrySet())
/*   92 */       this.ownskills.put(_e_.getKey(), _e_.getValue());
/*   93 */     this.yuanlv = _o_.yuanlv;
/*   94 */     this.subyuanlv = new ArrayList();
/*   95 */     this.subyuanlv.addAll(_o_.subyuanlv);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  100 */     this.partnercfgid = _o_.partnercfgid;
/*  101 */     this.hp = _o_.hp;
/*  102 */     this.mp = _o_.mp;
/*  103 */     this.skills = new ArrayList();
/*  104 */     this.skills.addAll(_o_.skills);
/*  105 */     this.loves = new ArrayList();
/*  106 */     this.loves.addAll(_o_.loves);
/*  107 */     this.lovestoreplace = new ArrayList();
/*  108 */     this.lovestoreplace.addAll(_o_.lovestoreplace);
/*  109 */     this.fightvalue = _o_.fightvalue;
/*  110 */     this.ownskills = new HashMap();
/*  111 */     for (Map.Entry<Integer, Integer> _e_ : _o_.ownskills.entrySet())
/*  112 */       this.ownskills.put(_e_.getKey(), _e_.getValue());
/*  113 */     this.yuanlv = _o_.yuanlv;
/*  114 */     this.subyuanlv = new ArrayList();
/*  115 */     this.subyuanlv.addAll(_o_.subyuanlv);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  121 */     _xdb_verify_unsafe_();
/*  122 */     _os_.marshal(this.partnercfgid);
/*  123 */     _os_.marshal(this.hp);
/*  124 */     _os_.marshal(this.mp);
/*  125 */     _os_.compact_uint32(this.skills.size());
/*  126 */     for (Integer _v_ : this.skills)
/*      */     {
/*  128 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  130 */     _os_.compact_uint32(this.loves.size());
/*  131 */     for (Integer _v_ : this.loves)
/*      */     {
/*  133 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  135 */     _os_.compact_uint32(this.lovestoreplace.size());
/*  136 */     for (Integer _v_ : this.lovestoreplace)
/*      */     {
/*  138 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  140 */     _os_.marshal(this.fightvalue);
/*  141 */     _os_.compact_uint32(this.ownskills.size());
/*  142 */     for (Map.Entry<Integer, Integer> _e_ : this.ownskills.entrySet())
/*      */     {
/*  144 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  145 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  147 */     _os_.marshal(this.yuanlv);
/*  148 */     _os_.compact_uint32(this.subyuanlv.size());
/*  149 */     for (Integer _v_ : this.subyuanlv)
/*      */     {
/*  151 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  153 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  159 */     _xdb_verify_unsafe_();
/*  160 */     this.partnercfgid = _os_.unmarshal_int();
/*  161 */     this.hp = _os_.unmarshal_int();
/*  162 */     this.mp = _os_.unmarshal_int();
/*  163 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  165 */       int _v_ = 0;
/*  166 */       _v_ = _os_.unmarshal_int();
/*  167 */       this.skills.add(Integer.valueOf(_v_));
/*      */     }
/*  169 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  171 */       int _v_ = 0;
/*  172 */       _v_ = _os_.unmarshal_int();
/*  173 */       this.loves.add(Integer.valueOf(_v_));
/*      */     }
/*  175 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  177 */       int _v_ = 0;
/*  178 */       _v_ = _os_.unmarshal_int();
/*  179 */       this.lovestoreplace.add(Integer.valueOf(_v_));
/*      */     }
/*  181 */     this.fightvalue = _os_.unmarshal_int();
/*      */     
/*  183 */     int size = _os_.uncompact_uint32();
/*  184 */     if (size >= 12)
/*      */     {
/*  186 */       this.ownskills = new HashMap(size * 2);
/*      */     }
/*  188 */     for (; size > 0; size--)
/*      */     {
/*  190 */       int _k_ = 0;
/*  191 */       _k_ = _os_.unmarshal_int();
/*  192 */       int _v_ = 0;
/*  193 */       _v_ = _os_.unmarshal_int();
/*  194 */       this.ownskills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  197 */     this.yuanlv = _os_.unmarshal_int();
/*  198 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  200 */       int _v_ = 0;
/*  201 */       _v_ = _os_.unmarshal_int();
/*  202 */       this.subyuanlv.add(Integer.valueOf(_v_));
/*      */     }
/*  204 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  210 */     _xdb_verify_unsafe_();
/*  211 */     int _size_ = 0;
/*  212 */     _size_ += CodedOutputStream.computeInt32Size(1, this.partnercfgid);
/*  213 */     _size_ += CodedOutputStream.computeInt32Size(2, this.hp);
/*  214 */     _size_ += CodedOutputStream.computeInt32Size(3, this.mp);
/*  215 */     for (Integer _v_ : this.skills)
/*      */     {
/*  217 */       _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */     }
/*  219 */     for (Integer _v_ : this.loves)
/*      */     {
/*  221 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  223 */     for (Integer _v_ : this.lovestoreplace)
/*      */     {
/*  225 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  227 */     _size_ += CodedOutputStream.computeInt32Size(7, this.fightvalue);
/*  228 */     for (Map.Entry<Integer, Integer> _e_ : this.ownskills.entrySet())
/*      */     {
/*  230 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/*  231 */       _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  233 */     _size_ += CodedOutputStream.computeInt32Size(9, this.yuanlv);
/*  234 */     for (Integer _v_ : this.subyuanlv)
/*      */     {
/*  236 */       _size_ += CodedOutputStream.computeInt32Size(10, _v_.intValue());
/*      */     }
/*  238 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  244 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  247 */       _output_.writeInt32(1, this.partnercfgid);
/*  248 */       _output_.writeInt32(2, this.hp);
/*  249 */       _output_.writeInt32(3, this.mp);
/*  250 */       for (Integer _v_ : this.skills)
/*      */       {
/*  252 */         _output_.writeInt32(4, _v_.intValue());
/*      */       }
/*  254 */       for (Integer _v_ : this.loves)
/*      */       {
/*  256 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*  258 */       for (Integer _v_ : this.lovestoreplace)
/*      */       {
/*  260 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*  262 */       _output_.writeInt32(7, this.fightvalue);
/*  263 */       for (Map.Entry<Integer, Integer> _e_ : this.ownskills.entrySet())
/*      */       {
/*  265 */         _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/*  266 */         _output_.writeInt32(8, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  268 */       _output_.writeInt32(9, this.yuanlv);
/*  269 */       for (Integer _v_ : this.subyuanlv)
/*      */       {
/*  271 */         _output_.writeInt32(10, _v_.intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  276 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  278 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  287 */       boolean done = false;
/*  288 */       while (!done)
/*      */       {
/*  290 */         int tag = _input_.readTag();
/*  291 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  295 */           done = true;
/*  296 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  300 */           this.partnercfgid = _input_.readInt32();
/*  301 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  305 */           this.hp = _input_.readInt32();
/*  306 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  310 */           this.mp = _input_.readInt32();
/*  311 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  315 */           int _v_ = 0;
/*  316 */           _v_ = _input_.readInt32();
/*  317 */           this.skills.add(Integer.valueOf(_v_));
/*  318 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  322 */           int _v_ = 0;
/*  323 */           _v_ = _input_.readInt32();
/*  324 */           this.loves.add(Integer.valueOf(_v_));
/*  325 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  329 */           int _v_ = 0;
/*  330 */           _v_ = _input_.readInt32();
/*  331 */           this.lovestoreplace.add(Integer.valueOf(_v_));
/*  332 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  336 */           this.fightvalue = _input_.readInt32();
/*  337 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  341 */           int _k_ = 0;
/*  342 */           _k_ = _input_.readInt32();
/*  343 */           int readTag = _input_.readTag();
/*  344 */           if (64 != readTag)
/*      */           {
/*  346 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  348 */           int _v_ = 0;
/*  349 */           _v_ = _input_.readInt32();
/*  350 */           this.ownskills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  351 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  355 */           this.yuanlv = _input_.readInt32();
/*  356 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  360 */           int _v_ = 0;
/*  361 */           _v_ = _input_.readInt32();
/*  362 */           this.subyuanlv.add(Integer.valueOf(_v_));
/*  363 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  367 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  369 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  378 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  382 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  384 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Property copy()
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     return new Property(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Property toData()
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Property toBean()
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     return new Property(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Property toDataIf()
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Property toBeanIf()
/*      */   {
/*  416 */     _xdb_verify_unsafe_();
/*  417 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  423 */     _xdb_verify_unsafe_();
/*  424 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPartnercfgid()
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     return this.partnercfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHp()
/*      */   {
/*  439 */     _xdb_verify_unsafe_();
/*  440 */     return this.hp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMp()
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     return this.mp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getSkills()
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     return Logs.logList(new LogKey(this, "skills"), this.skills);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getSkillsAsData()
/*      */   {
/*  462 */     _xdb_verify_unsafe_();
/*      */     
/*  464 */     Property _o_ = this;
/*  465 */     List<Integer> skills = new ArrayList();
/*  466 */     skills.addAll(_o_.skills);
/*  467 */     return skills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getLoves()
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*  475 */     return Logs.logList(new LogKey(this, "loves"), this.loves);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getLovesAsData()
/*      */   {
/*  481 */     _xdb_verify_unsafe_();
/*      */     
/*  483 */     Property _o_ = this;
/*  484 */     List<Integer> loves = new ArrayList();
/*  485 */     loves.addAll(_o_.loves);
/*  486 */     return loves;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getLovestoreplace()
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     return Logs.logList(new LogKey(this, "lovestoreplace"), this.lovestoreplace);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getLovestoreplaceAsData()
/*      */   {
/*  500 */     _xdb_verify_unsafe_();
/*      */     
/*  502 */     Property _o_ = this;
/*  503 */     List<Integer> lovestoreplace = new ArrayList();
/*  504 */     lovestoreplace.addAll(_o_.lovestoreplace);
/*  505 */     return lovestoreplace;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFightvalue()
/*      */   {
/*  512 */     _xdb_verify_unsafe_();
/*  513 */     return this.fightvalue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getOwnskills()
/*      */   {
/*  520 */     _xdb_verify_unsafe_();
/*  521 */     return Logs.logMap(new LogKey(this, "ownskills"), this.ownskills);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getOwnskillsAsData()
/*      */   {
/*  528 */     _xdb_verify_unsafe_();
/*      */     
/*  530 */     Property _o_ = this;
/*  531 */     Map<Integer, Integer> ownskills = new HashMap();
/*  532 */     for (Map.Entry<Integer, Integer> _e_ : _o_.ownskills.entrySet())
/*  533 */       ownskills.put(_e_.getKey(), _e_.getValue());
/*  534 */     return ownskills;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getYuanlv()
/*      */   {
/*  541 */     _xdb_verify_unsafe_();
/*  542 */     return this.yuanlv;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getSubyuanlv()
/*      */   {
/*  549 */     _xdb_verify_unsafe_();
/*  550 */     return Logs.logList(new LogKey(this, "subyuanlv"), this.subyuanlv);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getSubyuanlvAsData()
/*      */   {
/*  556 */     _xdb_verify_unsafe_();
/*      */     
/*  558 */     Property _o_ = this;
/*  559 */     List<Integer> subyuanlv = new ArrayList();
/*  560 */     subyuanlv.addAll(_o_.subyuanlv);
/*  561 */     return subyuanlv;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPartnercfgid(int _v_)
/*      */   {
/*  568 */     _xdb_verify_unsafe_();
/*  569 */     Logs.logIf(new LogKey(this, "partnercfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  573 */         new LogInt(this, Property.this.partnercfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  577 */             Property.this.partnercfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  581 */     });
/*  582 */     this.partnercfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHp(int _v_)
/*      */   {
/*  589 */     _xdb_verify_unsafe_();
/*  590 */     Logs.logIf(new LogKey(this, "hp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  594 */         new LogInt(this, Property.this.hp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  598 */             Property.this.hp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  602 */     });
/*  603 */     this.hp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMp(int _v_)
/*      */   {
/*  610 */     _xdb_verify_unsafe_();
/*  611 */     Logs.logIf(new LogKey(this, "mp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  615 */         new LogInt(this, Property.this.mp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  619 */             Property.this.mp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  623 */     });
/*  624 */     this.mp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFightvalue(int _v_)
/*      */   {
/*  631 */     _xdb_verify_unsafe_();
/*  632 */     Logs.logIf(new LogKey(this, "fightvalue")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  636 */         new LogInt(this, Property.this.fightvalue)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  640 */             Property.this.fightvalue = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  644 */     });
/*  645 */     this.fightvalue = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setYuanlv(int _v_)
/*      */   {
/*  652 */     _xdb_verify_unsafe_();
/*  653 */     Logs.logIf(new LogKey(this, "yuanlv")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  657 */         new LogInt(this, Property.this.yuanlv)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  661 */             Property.this.yuanlv = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  665 */     });
/*  666 */     this.yuanlv = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  672 */     _xdb_verify_unsafe_();
/*  673 */     Property _o_ = null;
/*  674 */     if ((_o1_ instanceof Property)) { _o_ = (Property)_o1_;
/*  675 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  676 */       return false;
/*  677 */     if (this.partnercfgid != _o_.partnercfgid) return false;
/*  678 */     if (this.hp != _o_.hp) return false;
/*  679 */     if (this.mp != _o_.mp) return false;
/*  680 */     if (!this.skills.equals(_o_.skills)) return false;
/*  681 */     if (!this.loves.equals(_o_.loves)) return false;
/*  682 */     if (!this.lovestoreplace.equals(_o_.lovestoreplace)) return false;
/*  683 */     if (this.fightvalue != _o_.fightvalue) return false;
/*  684 */     if (!this.ownskills.equals(_o_.ownskills)) return false;
/*  685 */     if (this.yuanlv != _o_.yuanlv) return false;
/*  686 */     if (!this.subyuanlv.equals(_o_.subyuanlv)) return false;
/*  687 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  693 */     _xdb_verify_unsafe_();
/*  694 */     int _h_ = 0;
/*  695 */     _h_ += this.partnercfgid;
/*  696 */     _h_ += this.hp;
/*  697 */     _h_ += this.mp;
/*  698 */     _h_ += this.skills.hashCode();
/*  699 */     _h_ += this.loves.hashCode();
/*  700 */     _h_ += this.lovestoreplace.hashCode();
/*  701 */     _h_ += this.fightvalue;
/*  702 */     _h_ += this.ownskills.hashCode();
/*  703 */     _h_ += this.yuanlv;
/*  704 */     _h_ += this.subyuanlv.hashCode();
/*  705 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  711 */     _xdb_verify_unsafe_();
/*  712 */     StringBuilder _sb_ = new StringBuilder();
/*  713 */     _sb_.append("(");
/*  714 */     _sb_.append(this.partnercfgid);
/*  715 */     _sb_.append(",");
/*  716 */     _sb_.append(this.hp);
/*  717 */     _sb_.append(",");
/*  718 */     _sb_.append(this.mp);
/*  719 */     _sb_.append(",");
/*  720 */     _sb_.append(this.skills);
/*  721 */     _sb_.append(",");
/*  722 */     _sb_.append(this.loves);
/*  723 */     _sb_.append(",");
/*  724 */     _sb_.append(this.lovestoreplace);
/*  725 */     _sb_.append(",");
/*  726 */     _sb_.append(this.fightvalue);
/*  727 */     _sb_.append(",");
/*  728 */     _sb_.append(this.ownskills);
/*  729 */     _sb_.append(",");
/*  730 */     _sb_.append(this.yuanlv);
/*  731 */     _sb_.append(",");
/*  732 */     _sb_.append(this.subyuanlv);
/*  733 */     _sb_.append(")");
/*  734 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  740 */     ListenableBean lb = new ListenableBean();
/*  741 */     lb.add(new ListenableChanged().setVarName("partnercfgid"));
/*  742 */     lb.add(new ListenableChanged().setVarName("hp"));
/*  743 */     lb.add(new ListenableChanged().setVarName("mp"));
/*  744 */     lb.add(new ListenableChanged().setVarName("skills"));
/*  745 */     lb.add(new ListenableChanged().setVarName("loves"));
/*  746 */     lb.add(new ListenableChanged().setVarName("lovestoreplace"));
/*  747 */     lb.add(new ListenableChanged().setVarName("fightvalue"));
/*  748 */     lb.add(new xdb.logs.ListenableMap().setVarName("ownskills"));
/*  749 */     lb.add(new ListenableChanged().setVarName("yuanlv"));
/*  750 */     lb.add(new ListenableChanged().setVarName("subyuanlv"));
/*  751 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Property {
/*      */     private Const() {}
/*      */     
/*      */     Property nThis() {
/*  758 */       return Property.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  764 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Property copy()
/*      */     {
/*  770 */       return Property.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Property toData()
/*      */     {
/*  776 */       return Property.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Property toBean()
/*      */     {
/*  781 */       return Property.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Property toDataIf()
/*      */     {
/*  787 */       return Property.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Property toBeanIf()
/*      */     {
/*  792 */       return Property.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPartnercfgid()
/*      */     {
/*  799 */       Property.this._xdb_verify_unsafe_();
/*  800 */       return Property.this.partnercfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHp()
/*      */     {
/*  807 */       Property.this._xdb_verify_unsafe_();
/*  808 */       return Property.this.hp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMp()
/*      */     {
/*  815 */       Property.this._xdb_verify_unsafe_();
/*  816 */       return Property.this.mp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSkills()
/*      */     {
/*  823 */       Property.this._xdb_verify_unsafe_();
/*  824 */       return xdb.Consts.constList(Property.this.skills);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getSkillsAsData()
/*      */     {
/*  830 */       Property.this._xdb_verify_unsafe_();
/*      */       
/*  832 */       Property _o_ = Property.this;
/*  833 */       List<Integer> skills = new ArrayList();
/*  834 */       skills.addAll(_o_.skills);
/*  835 */       return skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getLoves()
/*      */     {
/*  842 */       Property.this._xdb_verify_unsafe_();
/*  843 */       return xdb.Consts.constList(Property.this.loves);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getLovesAsData()
/*      */     {
/*  849 */       Property.this._xdb_verify_unsafe_();
/*      */       
/*  851 */       Property _o_ = Property.this;
/*  852 */       List<Integer> loves = new ArrayList();
/*  853 */       loves.addAll(_o_.loves);
/*  854 */       return loves;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getLovestoreplace()
/*      */     {
/*  861 */       Property.this._xdb_verify_unsafe_();
/*  862 */       return xdb.Consts.constList(Property.this.lovestoreplace);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getLovestoreplaceAsData()
/*      */     {
/*  868 */       Property.this._xdb_verify_unsafe_();
/*      */       
/*  870 */       Property _o_ = Property.this;
/*  871 */       List<Integer> lovestoreplace = new ArrayList();
/*  872 */       lovestoreplace.addAll(_o_.lovestoreplace);
/*  873 */       return lovestoreplace;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFightvalue()
/*      */     {
/*  880 */       Property.this._xdb_verify_unsafe_();
/*  881 */       return Property.this.fightvalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOwnskills()
/*      */     {
/*  888 */       Property.this._xdb_verify_unsafe_();
/*  889 */       return xdb.Consts.constMap(Property.this.ownskills);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOwnskillsAsData()
/*      */     {
/*  896 */       Property.this._xdb_verify_unsafe_();
/*      */       
/*  898 */       Property _o_ = Property.this;
/*  899 */       Map<Integer, Integer> ownskills = new HashMap();
/*  900 */       for (Map.Entry<Integer, Integer> _e_ : _o_.ownskills.entrySet())
/*  901 */         ownskills.put(_e_.getKey(), _e_.getValue());
/*  902 */       return ownskills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getYuanlv()
/*      */     {
/*  909 */       Property.this._xdb_verify_unsafe_();
/*  910 */       return Property.this.yuanlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSubyuanlv()
/*      */     {
/*  917 */       Property.this._xdb_verify_unsafe_();
/*  918 */       return xdb.Consts.constList(Property.this.subyuanlv);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getSubyuanlvAsData()
/*      */     {
/*  924 */       Property.this._xdb_verify_unsafe_();
/*      */       
/*  926 */       Property _o_ = Property.this;
/*  927 */       List<Integer> subyuanlv = new ArrayList();
/*  928 */       subyuanlv.addAll(_o_.subyuanlv);
/*  929 */       return subyuanlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPartnercfgid(int _v_)
/*      */     {
/*  936 */       Property.this._xdb_verify_unsafe_();
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHp(int _v_)
/*      */     {
/*  944 */       Property.this._xdb_verify_unsafe_();
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMp(int _v_)
/*      */     {
/*  952 */       Property.this._xdb_verify_unsafe_();
/*  953 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightvalue(int _v_)
/*      */     {
/*  960 */       Property.this._xdb_verify_unsafe_();
/*  961 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYuanlv(int _v_)
/*      */     {
/*  968 */       Property.this._xdb_verify_unsafe_();
/*  969 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  975 */       Property.this._xdb_verify_unsafe_();
/*  976 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  982 */       Property.this._xdb_verify_unsafe_();
/*  983 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  989 */       return Property.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  995 */       return Property.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1001 */       Property.this._xdb_verify_unsafe_();
/* 1002 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1008 */       return Property.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1014 */       return Property.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1020 */       Property.this._xdb_verify_unsafe_();
/* 1021 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/* 1027 */       return Property.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1033 */       return Property.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1039 */       return Property.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1045 */       return Property.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1051 */       return Property.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1057 */       return Property.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1063 */       return Property.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Property
/*      */   {
/*      */     private int partnercfgid;
/*      */     
/*      */     private int hp;
/*      */     
/*      */     private int mp;
/*      */     
/*      */     private ArrayList<Integer> skills;
/*      */     
/*      */     private ArrayList<Integer> loves;
/*      */     
/*      */     private ArrayList<Integer> lovestoreplace;
/*      */     
/*      */     private int fightvalue;
/*      */     
/*      */     private HashMap<Integer, Integer> ownskills;
/*      */     
/*      */     private int yuanlv;
/*      */     
/*      */     private ArrayList<Integer> subyuanlv;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1093 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1098 */       this.skills = new ArrayList();
/* 1099 */       this.loves = new ArrayList();
/* 1100 */       this.lovestoreplace = new ArrayList();
/* 1101 */       this.ownskills = new HashMap();
/* 1102 */       this.subyuanlv = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.Property _o1_)
/*      */     {
/* 1107 */       if ((_o1_ instanceof Property)) { assign((Property)_o1_);
/* 1108 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1109 */       } else if ((_o1_ instanceof Property.Const)) assign(((Property.Const)_o1_).nThis()); else {
/* 1110 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Property _o_) {
/* 1115 */       this.partnercfgid = _o_.partnercfgid;
/* 1116 */       this.hp = _o_.hp;
/* 1117 */       this.mp = _o_.mp;
/* 1118 */       this.skills = new ArrayList();
/* 1119 */       this.skills.addAll(_o_.skills);
/* 1120 */       this.loves = new ArrayList();
/* 1121 */       this.loves.addAll(_o_.loves);
/* 1122 */       this.lovestoreplace = new ArrayList();
/* 1123 */       this.lovestoreplace.addAll(_o_.lovestoreplace);
/* 1124 */       this.fightvalue = _o_.fightvalue;
/* 1125 */       this.ownskills = new HashMap();
/* 1126 */       for (Map.Entry<Integer, Integer> _e_ : _o_.ownskills.entrySet())
/* 1127 */         this.ownskills.put(_e_.getKey(), _e_.getValue());
/* 1128 */       this.yuanlv = _o_.yuanlv;
/* 1129 */       this.subyuanlv = new ArrayList();
/* 1130 */       this.subyuanlv.addAll(_o_.subyuanlv);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1135 */       this.partnercfgid = _o_.partnercfgid;
/* 1136 */       this.hp = _o_.hp;
/* 1137 */       this.mp = _o_.mp;
/* 1138 */       this.skills = new ArrayList();
/* 1139 */       this.skills.addAll(_o_.skills);
/* 1140 */       this.loves = new ArrayList();
/* 1141 */       this.loves.addAll(_o_.loves);
/* 1142 */       this.lovestoreplace = new ArrayList();
/* 1143 */       this.lovestoreplace.addAll(_o_.lovestoreplace);
/* 1144 */       this.fightvalue = _o_.fightvalue;
/* 1145 */       this.ownskills = new HashMap();
/* 1146 */       for (Map.Entry<Integer, Integer> _e_ : _o_.ownskills.entrySet())
/* 1147 */         this.ownskills.put(_e_.getKey(), _e_.getValue());
/* 1148 */       this.yuanlv = _o_.yuanlv;
/* 1149 */       this.subyuanlv = new ArrayList();
/* 1150 */       this.subyuanlv.addAll(_o_.subyuanlv);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1156 */       _os_.marshal(this.partnercfgid);
/* 1157 */       _os_.marshal(this.hp);
/* 1158 */       _os_.marshal(this.mp);
/* 1159 */       _os_.compact_uint32(this.skills.size());
/* 1160 */       for (Integer _v_ : this.skills)
/*      */       {
/* 1162 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1164 */       _os_.compact_uint32(this.loves.size());
/* 1165 */       for (Integer _v_ : this.loves)
/*      */       {
/* 1167 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1169 */       _os_.compact_uint32(this.lovestoreplace.size());
/* 1170 */       for (Integer _v_ : this.lovestoreplace)
/*      */       {
/* 1172 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1174 */       _os_.marshal(this.fightvalue);
/* 1175 */       _os_.compact_uint32(this.ownskills.size());
/* 1176 */       for (Map.Entry<Integer, Integer> _e_ : this.ownskills.entrySet())
/*      */       {
/* 1178 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1179 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1181 */       _os_.marshal(this.yuanlv);
/* 1182 */       _os_.compact_uint32(this.subyuanlv.size());
/* 1183 */       for (Integer _v_ : this.subyuanlv)
/*      */       {
/* 1185 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1187 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1193 */       this.partnercfgid = _os_.unmarshal_int();
/* 1194 */       this.hp = _os_.unmarshal_int();
/* 1195 */       this.mp = _os_.unmarshal_int();
/* 1196 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1198 */         int _v_ = 0;
/* 1199 */         _v_ = _os_.unmarshal_int();
/* 1200 */         this.skills.add(Integer.valueOf(_v_));
/*      */       }
/* 1202 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1204 */         int _v_ = 0;
/* 1205 */         _v_ = _os_.unmarshal_int();
/* 1206 */         this.loves.add(Integer.valueOf(_v_));
/*      */       }
/* 1208 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1210 */         int _v_ = 0;
/* 1211 */         _v_ = _os_.unmarshal_int();
/* 1212 */         this.lovestoreplace.add(Integer.valueOf(_v_));
/*      */       }
/* 1214 */       this.fightvalue = _os_.unmarshal_int();
/*      */       
/* 1216 */       int size = _os_.uncompact_uint32();
/* 1217 */       if (size >= 12)
/*      */       {
/* 1219 */         this.ownskills = new HashMap(size * 2);
/*      */       }
/* 1221 */       for (; size > 0; size--)
/*      */       {
/* 1223 */         int _k_ = 0;
/* 1224 */         _k_ = _os_.unmarshal_int();
/* 1225 */         int _v_ = 0;
/* 1226 */         _v_ = _os_.unmarshal_int();
/* 1227 */         this.ownskills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1230 */       this.yuanlv = _os_.unmarshal_int();
/* 1231 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1233 */         int _v_ = 0;
/* 1234 */         _v_ = _os_.unmarshal_int();
/* 1235 */         this.subyuanlv.add(Integer.valueOf(_v_));
/*      */       }
/* 1237 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1243 */       int _size_ = 0;
/* 1244 */       _size_ += CodedOutputStream.computeInt32Size(1, this.partnercfgid);
/* 1245 */       _size_ += CodedOutputStream.computeInt32Size(2, this.hp);
/* 1246 */       _size_ += CodedOutputStream.computeInt32Size(3, this.mp);
/* 1247 */       for (Integer _v_ : this.skills)
/*      */       {
/* 1249 */         _size_ += CodedOutputStream.computeInt32Size(4, _v_.intValue());
/*      */       }
/* 1251 */       for (Integer _v_ : this.loves)
/*      */       {
/* 1253 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/* 1255 */       for (Integer _v_ : this.lovestoreplace)
/*      */       {
/* 1257 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/* 1259 */       _size_ += CodedOutputStream.computeInt32Size(7, this.fightvalue);
/* 1260 */       for (Map.Entry<Integer, Integer> _e_ : this.ownskills.entrySet())
/*      */       {
/* 1262 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getKey()).intValue());
/* 1263 */         _size_ += CodedOutputStream.computeInt32Size(8, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1265 */       _size_ += CodedOutputStream.computeInt32Size(9, this.yuanlv);
/* 1266 */       for (Integer _v_ : this.subyuanlv)
/*      */       {
/* 1268 */         _size_ += CodedOutputStream.computeInt32Size(10, _v_.intValue());
/*      */       }
/* 1270 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1278 */         _output_.writeInt32(1, this.partnercfgid);
/* 1279 */         _output_.writeInt32(2, this.hp);
/* 1280 */         _output_.writeInt32(3, this.mp);
/* 1281 */         for (Integer _v_ : this.skills)
/*      */         {
/* 1283 */           _output_.writeInt32(4, _v_.intValue());
/*      */         }
/* 1285 */         for (Integer _v_ : this.loves)
/*      */         {
/* 1287 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/* 1289 */         for (Integer _v_ : this.lovestoreplace)
/*      */         {
/* 1291 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/* 1293 */         _output_.writeInt32(7, this.fightvalue);
/* 1294 */         for (Map.Entry<Integer, Integer> _e_ : this.ownskills.entrySet())
/*      */         {
/* 1296 */           _output_.writeInt32(8, ((Integer)_e_.getKey()).intValue());
/* 1297 */           _output_.writeInt32(8, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1299 */         _output_.writeInt32(9, this.yuanlv);
/* 1300 */         for (Integer _v_ : this.subyuanlv)
/*      */         {
/* 1302 */           _output_.writeInt32(10, _v_.intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1307 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1309 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1317 */         boolean done = false;
/* 1318 */         while (!done)
/*      */         {
/* 1320 */           int tag = _input_.readTag();
/* 1321 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1325 */             done = true;
/* 1326 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1330 */             this.partnercfgid = _input_.readInt32();
/* 1331 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1335 */             this.hp = _input_.readInt32();
/* 1336 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1340 */             this.mp = _input_.readInt32();
/* 1341 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1345 */             int _v_ = 0;
/* 1346 */             _v_ = _input_.readInt32();
/* 1347 */             this.skills.add(Integer.valueOf(_v_));
/* 1348 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1352 */             int _v_ = 0;
/* 1353 */             _v_ = _input_.readInt32();
/* 1354 */             this.loves.add(Integer.valueOf(_v_));
/* 1355 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1359 */             int _v_ = 0;
/* 1360 */             _v_ = _input_.readInt32();
/* 1361 */             this.lovestoreplace.add(Integer.valueOf(_v_));
/* 1362 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1366 */             this.fightvalue = _input_.readInt32();
/* 1367 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1371 */             int _k_ = 0;
/* 1372 */             _k_ = _input_.readInt32();
/* 1373 */             int readTag = _input_.readTag();
/* 1374 */             if (64 != readTag)
/*      */             {
/* 1376 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1378 */             int _v_ = 0;
/* 1379 */             _v_ = _input_.readInt32();
/* 1380 */             this.ownskills.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1381 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1385 */             this.yuanlv = _input_.readInt32();
/* 1386 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1390 */             int _v_ = 0;
/* 1391 */             _v_ = _input_.readInt32();
/* 1392 */             this.subyuanlv.add(Integer.valueOf(_v_));
/* 1393 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1397 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1399 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1408 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1412 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1414 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Property copy()
/*      */     {
/* 1420 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Property toData()
/*      */     {
/* 1426 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Property toBean()
/*      */     {
/* 1431 */       return new Property(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Property toDataIf()
/*      */     {
/* 1437 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Property toBeanIf()
/*      */     {
/* 1442 */       return new Property(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1448 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1452 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1456 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1460 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1464 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1468 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1472 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPartnercfgid()
/*      */     {
/* 1479 */       return this.partnercfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHp()
/*      */     {
/* 1486 */       return this.hp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMp()
/*      */     {
/* 1493 */       return this.mp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSkills()
/*      */     {
/* 1500 */       return this.skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSkillsAsData()
/*      */     {
/* 1507 */       return this.skills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getLoves()
/*      */     {
/* 1514 */       return this.loves;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getLovesAsData()
/*      */     {
/* 1521 */       return this.loves;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getLovestoreplace()
/*      */     {
/* 1528 */       return this.lovestoreplace;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getLovestoreplaceAsData()
/*      */     {
/* 1535 */       return this.lovestoreplace;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFightvalue()
/*      */     {
/* 1542 */       return this.fightvalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOwnskills()
/*      */     {
/* 1549 */       return this.ownskills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOwnskillsAsData()
/*      */     {
/* 1556 */       return this.ownskills;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getYuanlv()
/*      */     {
/* 1563 */       return this.yuanlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSubyuanlv()
/*      */     {
/* 1570 */       return this.subyuanlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getSubyuanlvAsData()
/*      */     {
/* 1577 */       return this.subyuanlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPartnercfgid(int _v_)
/*      */     {
/* 1584 */       this.partnercfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHp(int _v_)
/*      */     {
/* 1591 */       this.hp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMp(int _v_)
/*      */     {
/* 1598 */       this.mp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightvalue(int _v_)
/*      */     {
/* 1605 */       this.fightvalue = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYuanlv(int _v_)
/*      */     {
/* 1612 */       this.yuanlv = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1618 */       if (!(_o1_ instanceof Data)) return false;
/* 1619 */       Data _o_ = (Data)_o1_;
/* 1620 */       if (this.partnercfgid != _o_.partnercfgid) return false;
/* 1621 */       if (this.hp != _o_.hp) return false;
/* 1622 */       if (this.mp != _o_.mp) return false;
/* 1623 */       if (!this.skills.equals(_o_.skills)) return false;
/* 1624 */       if (!this.loves.equals(_o_.loves)) return false;
/* 1625 */       if (!this.lovestoreplace.equals(_o_.lovestoreplace)) return false;
/* 1626 */       if (this.fightvalue != _o_.fightvalue) return false;
/* 1627 */       if (!this.ownskills.equals(_o_.ownskills)) return false;
/* 1628 */       if (this.yuanlv != _o_.yuanlv) return false;
/* 1629 */       if (!this.subyuanlv.equals(_o_.subyuanlv)) return false;
/* 1630 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1636 */       int _h_ = 0;
/* 1637 */       _h_ += this.partnercfgid;
/* 1638 */       _h_ += this.hp;
/* 1639 */       _h_ += this.mp;
/* 1640 */       _h_ += this.skills.hashCode();
/* 1641 */       _h_ += this.loves.hashCode();
/* 1642 */       _h_ += this.lovestoreplace.hashCode();
/* 1643 */       _h_ += this.fightvalue;
/* 1644 */       _h_ += this.ownskills.hashCode();
/* 1645 */       _h_ += this.yuanlv;
/* 1646 */       _h_ += this.subyuanlv.hashCode();
/* 1647 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1653 */       StringBuilder _sb_ = new StringBuilder();
/* 1654 */       _sb_.append("(");
/* 1655 */       _sb_.append(this.partnercfgid);
/* 1656 */       _sb_.append(",");
/* 1657 */       _sb_.append(this.hp);
/* 1658 */       _sb_.append(",");
/* 1659 */       _sb_.append(this.mp);
/* 1660 */       _sb_.append(",");
/* 1661 */       _sb_.append(this.skills);
/* 1662 */       _sb_.append(",");
/* 1663 */       _sb_.append(this.loves);
/* 1664 */       _sb_.append(",");
/* 1665 */       _sb_.append(this.lovestoreplace);
/* 1666 */       _sb_.append(",");
/* 1667 */       _sb_.append(this.fightvalue);
/* 1668 */       _sb_.append(",");
/* 1669 */       _sb_.append(this.ownskills);
/* 1670 */       _sb_.append(",");
/* 1671 */       _sb_.append(this.yuanlv);
/* 1672 */       _sb_.append(",");
/* 1673 */       _sb_.append(this.subyuanlv);
/* 1674 */       _sb_.append(")");
/* 1675 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */